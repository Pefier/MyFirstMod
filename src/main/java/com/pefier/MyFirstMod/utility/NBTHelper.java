package com.pefier.MyFirstMod.utility;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Created by New Profile on 12.03.2016.
 */
public class NBTHelper {

    public static boolean getNBTTagBoolean(ItemStack itemstack,String tag,String MasterTag){
        NBTTagCompound data =itemstack.getTagCompound().getCompoundTag(MasterTag);

        return data.getBoolean(tag);
    }

    public static void setNBTTagBoolean(ItemStack itemStack,String tag,String MasterTag,boolean bool){
        NBTTagCompound data = itemStack.getTagCompound().getCompoundTag(MasterTag);
        data.setBoolean(tag, bool);
    }
}
