package com.pefier.MyFirstMod.item;

import com.pefier.MyFirstMod.entity.throwabel.EntityLaser;
import com.pefier.MyFirstMod.reference.Name;
import com.pefier.MyFirstMod.reference.Reference;
import com.pefier.MyFirstMod.utility.NBTHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.List;

/**
 * Created by New Profile on 21.03.2016.
 */
public class ItemRingGreenLanter extends ItemMFM {

    private static final String name = "RingGreenLantern";

    public ItemRingGreenLanter(){
        super();
        setUnlocalizedName(name);
        setMaxStackSize(1);
        GameRegistry.registerItem(this, name);
        setHasSubtypes(true);


    }

    public static String getName() {
        return name;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
        if(playerIn.isSneaking()) {

            if (NBTHelper.getNBTTagBoolean(itemStackIn, Name.NBTKey.TAG_STATUS, Name.NBTKey.TAG_RINGDATA) && NBTHelper.getNBTTagInt(itemStackIn, Name.NBTKey.TAG_CHARGE, Name.NBTKey.TAG_RINGDATA) > 0) {
                playerIn.capabilities.allowFlying = true;
                playerIn.capabilities.isFlying = true;
                System.out.println("aktive");
                itemStackIn.setItemDamage(1);
                NBTHelper.setNBTTagBoolean(itemStackIn, Name.NBTKey.TAG_STATUS, Name.NBTKey.TAG_RINGDATA, false);
            } else {
                playerIn.capabilities.allowFlying = false;
                playerIn.capabilities.isFlying = false;
                System.out.println("inaktiv");
                itemStackIn.setItemDamage(0);
                NBTHelper.setNBTTagBoolean(itemStackIn, Name.NBTKey.TAG_STATUS, Name.NBTKey.TAG_RINGDATA, true);
            }
            System.out.print(NBTHelper.getNBTTagInt(itemStackIn, Name.NBTKey.TAG_CHARGE, Name.NBTKey.TAG_RINGDATA));
        }else{
            if(!NBTHelper.getNBTTagBoolean(itemStackIn, Name.NBTKey.TAG_STATUS, Name.NBTKey.TAG_RINGDATA) &&  NBTHelper.getNBTTagInt(itemStackIn, Name.NBTKey.TAG_CHARGE, Name.NBTKey.TAG_RINGDATA) > 0){

                int charge = NBTHelper.getNBTTagInt(itemStackIn, Name.NBTKey.TAG_CHARGE, Name.NBTKey.TAG_RINGDATA);
                worldIn.playSoundAtEntity(playerIn, Reference.MOD_ID+":laser", 0.1F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
                if (!worldIn.isRemote)
                {
                    worldIn.spawnEntityInWorld(new EntityLaser(worldIn, playerIn));
                    charge-= 15 ;
                    NBTHelper.setNBTTagInt(itemStackIn, Name.NBTKey.TAG_CHARGE, Name.NBTKey.TAG_RINGDATA, charge);
                }
            }

        }
            return itemStackIn;
    }

    @Override
    public void onUpdate(ItemStack itemStackIn, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        super.onUpdate(itemStackIn, worldIn, entityIn, itemSlot, isSelected);
        if(itemStackIn.hasTagCompound()) {
            int charge = NBTHelper.getNBTTagInt(itemStackIn, Name.NBTKey.TAG_CHARGE, Name.NBTKey.TAG_RINGDATA);
                if (NBTHelper.getNBTTagInt(itemStackIn, Name.NBTKey.TAG_CHARGE, Name.NBTKey.TAG_RINGDATA) > 0 && !NBTHelper.getNBTTagBoolean(itemStackIn, Name.NBTKey.TAG_STATUS, Name.NBTKey.TAG_RINGDATA)) {
                    charge--;
                    NBTHelper.setNBTTagInt(itemStackIn, Name.NBTKey.TAG_CHARGE, Name.NBTKey.TAG_RINGDATA, charge);
                }
                if (NBTHelper.getNBTTagInt(itemStackIn, Name.NBTKey.TAG_CHARGE, Name.NBTKey.TAG_RINGDATA) <= 0) {
                    if (entityIn instanceof EntityPlayer) {
                        ((EntityPlayer) entityIn).capabilities.isFlying = false;
                        ((EntityPlayer) entityIn).capabilities.allowFlying = false;
                        NBTHelper.setNBTTagBoolean(itemStackIn, Name.NBTKey.TAG_STATUS, Name.NBTKey.TAG_RINGDATA, true);
                        itemStackIn.setItemDamage(0);

                    }


                }
        }

    }
    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "." + (stack.getItemDamage() == 0 ? "aktive" : "normal");
    }

    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List subItems) {
        subItems.add(new ItemStack(itemIn, 1, 0));
        subItems.add(new ItemStack(itemIn, 1, 1));
    }
}