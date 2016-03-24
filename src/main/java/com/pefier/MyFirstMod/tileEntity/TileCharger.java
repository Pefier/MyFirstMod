package com.pefier.MyFirstMod.tileEntity;

import com.pefier.MyFirstMod.init.ModItems;
import com.pefier.MyFirstMod.utility.NBTHelper;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.ITickable;


/**
 * Created by New Profile on 22.03.2016.
 */
public class TileCharger extends TileEntity implements ITickable{

    public InventoryBasic inventory;

    public TileCharger(){
        inventory =new InventoryBasic("Charger",false,1);

    }
    @Override
    public void writeToNBT(NBTTagCompound compound){

        NBTTagCompound tag =new NBTTagCompound();
        if(inventory.getStackInSlot(0) != null){
            tag.setByte("slot",(byte) 0);
            inventory.getStackInSlot(0).writeToNBT(tag);
        }
        compound.setTag("Item", tag);
    }
    @Override
    public void readFromNBT(NBTTagCompound compound){
        NBTTagCompound tag = (NBTTagCompound) compound.getTag("Item");
        this.inventory = new InventoryBasic("Charger",false,1);
        byte b = tag.getByte("slot");
        if(b >= 0 && b < 1){
            inventory.setInventorySlotContents(b, ItemStack.loadItemStackFromNBT(tag));
        }



    }

    @Override
    public void update() {
        int charge = 0;
        if(this.inventory.getStackInSlot(0)!=null){
            if (this.inventory.getStackInSlot(0).getItem()== ModItems.ringGreenLantern){
                ItemStack itemStack=this.inventory.getStackInSlot(0);
                NBTTagCompound data = new NBTTagCompound();
                charge = NBTHelper.getNBTTagInt(itemStack,"tag_charge","tag_lantern");
                if(charge < 1000){
                    charge++;

                }

                NBTHelper.setNBTTagInt(itemStack,"tag_charge","tag_lantern", charge);

            }

        }



    }
}
