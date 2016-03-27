package com.pefier.MyFirstMod.item;

import com.pefier.MyFirstMod.utility.NBTHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by New Profile on 21.03.2016.
 */
public class ItemRingGreenLanter extends ItemMFM {

    private static final String name = "RingGreenLantern";

    private static final String TAG_LANTERN = "tag_lantern";
    private static final String TAG_CHARGE ="tag_charge";
    private static final String TAG_STATUS ="tag_status";

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
        if (itemStackIn.getTagCompound() == null) {
            NBTTagCompound data = new NBTTagCompound();
            data.setInteger(TAG_CHARGE, 0);
            data.setBoolean(TAG_STATUS,true);
            itemStackIn.setTagInfo(TAG_LANTERN, data);
    }

            if (NBTHelper.getNBTTagBoolean(itemStackIn, TAG_STATUS, TAG_LANTERN)&& NBTHelper.getNBTTagInt(itemStackIn,TAG_CHARGE,TAG_LANTERN) > 0) {
                playerIn.capabilities.allowFlying = true;
                playerIn.capabilities.isFlying = true;
                System.out.println("aktive");
                itemStackIn.setItemDamage(1);
                NBTHelper.setNBTTagBoolean(itemStackIn, TAG_STATUS, TAG_LANTERN, false);
            } else {
                playerIn.capabilities.allowFlying = false;
                playerIn.capabilities.isFlying = false;
                System.out.println("inaktiv");
                itemStackIn.setItemDamage(0);
                NBTHelper.setNBTTagBoolean(itemStackIn, TAG_STATUS, TAG_LANTERN, true);
            }

        System.out.print(NBTHelper.getNBTTagInt(itemStackIn,TAG_CHARGE,TAG_LANTERN));



        return itemStackIn;
    }

    @Override
    public void onUpdate(ItemStack itemStackIn, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        super.onUpdate(itemStackIn, worldIn, entityIn, itemSlot, isSelected);
        if(itemStackIn.hasTagCompound()) {
            int charge = NBTHelper.getNBTTagInt(itemStackIn, TAG_CHARGE, TAG_LANTERN);
                if (NBTHelper.getNBTTagInt(itemStackIn, TAG_CHARGE, TAG_LANTERN) > 0 && !NBTHelper.getNBTTagBoolean(itemStackIn, TAG_STATUS, TAG_LANTERN)) {
                    charge--;
                    NBTHelper.setNBTTagInt(itemStackIn, TAG_CHARGE, TAG_LANTERN, charge);
                }
                if (NBTHelper.getNBTTagInt(itemStackIn, TAG_CHARGE, TAG_LANTERN) == 0) {
                    if (entityIn instanceof EntityPlayer) {
                        ((EntityPlayer) entityIn).capabilities.isFlying = false;
                        ((EntityPlayer) entityIn).capabilities.allowFlying = false;
                        itemStackIn.setItemDamage(0);
                    }


                }
        }

    }
}