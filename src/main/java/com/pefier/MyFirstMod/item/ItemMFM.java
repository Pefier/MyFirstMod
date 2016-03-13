package com.pefier.MyFirstMod.item;

import com.pefier.MyFirstMod.creativtab.CreativeTabMFM;
import com.pefier.MyFirstMod.reference.Reference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by New Profile on 13.03.2016.
 */
public class ItemMFM extends Item {


    public ItemMFM()
    {
        super();
        this.setCreativeTab(CreativeTabMFM.MY_TAB);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }




}
