package com.pefier.MyFirstMod.item;

import com.pefier.MyFirstMod.creativtab.CreativeTabMFM;
import com.pefier.MyFirstMod.reference.Reference;
import com.pefier.MyFirstMod.utility.NBTHelper;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Pefier on 10.03.2016.
 */
public class ItemRingFlash extends ItemMFM {

    private final String name ="RingFlash";
    private static final String TAG_FLASH = "tag_flash";
    private static final String TAG_STATUS ="tag_status";


    public ItemRingFlash(){

        GameRegistry.registerItem( this , name);
        setUnlocalizedName(name);
    }
    public String getName(){
        return name;
    }



    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
        if (itemStackIn.getTagCompound()==null){
            NBTTagCompound data = new NBTTagCompound();
            data.setBoolean(TAG_STATUS, false);
            itemStackIn.setTagInfo(TAG_FLASH,data);
            System.out.println("Initializing tag");
        }
        if(NBTHelper.getNBTTagBoolean(itemStackIn,TAG_STATUS,TAG_FLASH)){

            Double a = playerIn.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getBaseValue();
            System.out.println("if Aktuell MovementSpeed" + a);
            NBTHelper.setNBTTagBoolean(itemStackIn,TAG_STATUS,TAG_FLASH,false);
        }else{


            Double a = playerIn.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getBaseValue();
            System.out.println("else Aktuell MovementSpeed" + a);
            NBTHelper.setNBTTagBoolean(itemStackIn,TAG_STATUS,TAG_FLASH, true);

        }



        Double a = playerIn.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getBaseValue();
        System.out.println("Aktuell MovementSpeed" + a);
        return super.onItemRightClick(itemStackIn, worldIn, playerIn);
    }
}
