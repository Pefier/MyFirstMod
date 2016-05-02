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

    public static void setNBTTagInt(ItemStack itemStack,String tag, String MasterTag, int wert){
        NBTTagCompound data = itemStack.getTagCompound().getCompoundTag(MasterTag);
        data.setInteger(tag,wert);
    }

    public static int getNBTTagInt(ItemStack itemStack,String tag, String MasterTag){
        NBTTagCompound data = itemStack.getTagCompound().getCompoundTag(MasterTag);
        return  data.getInteger(tag);
    }

    public static void setNBTTagDouble(ItemStack itemStack,String tag, String MasterTag, double wert){
        NBTTagCompound data = itemStack.getTagCompound().getCompoundTag(MasterTag);
        data.setDouble(tag,wert);
    }

    public static double getNBTTagDouble(ItemStack itemStack,String tag, String MasterTag){
        NBTTagCompound data = itemStack.getTagCompound().getCompoundTag(MasterTag);
        return  data.getDouble(tag);

    }
    public static String printNBTInt(ItemStack itemStack,String tag, String MasterTag,String befor){
        NBTTagCompound data = itemStack.getTagCompound().getCompoundTag(MasterTag);

        String value = "" + data.getInteger(tag);

        return befor + value;
    }
    public static String printNBTDouble(ItemStack itemStack,String tag, String MasterTag,String befor){
        NBTTagCompound data = itemStack.getTagCompound().getCompoundTag(MasterTag);

        String value = String.format("%.2f",data.getDouble(tag));

        return befor + value;
    }


}
