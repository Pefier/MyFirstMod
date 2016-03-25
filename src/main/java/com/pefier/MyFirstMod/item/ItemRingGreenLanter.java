package com.pefier.MyFirstMod.item;

import com.pefier.MyFirstMod.utility.NBTHelper;
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

    public ItemRingGreenLanter(){
        super();
        setUnlocalizedName(name);
        setMaxStackSize(1);
        GameRegistry.registerItem(this, name);


    }

    public static String getName() {
        return name;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
        if (itemStackIn.getTagCompound() == null) {
            NBTTagCompound data = new NBTTagCompound();
            data.setInteger(TAG_CHARGE, 0);
            itemStackIn.setTagInfo(TAG_LANTERN, data);
    }
        System.out.print(NBTHelper.getNBTTagInt(itemStackIn,TAG_CHARGE,TAG_LANTERN));



        return itemStackIn;
    }

}
