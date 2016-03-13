package com.pefier.MyFirstMod.item;


import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by New Profile on 07.03.2016.
 */
public class ItemBambus extends ItemMFM {

    private final String name = "Bambus";

    public ItemBambus(){

        GameRegistry.registerItem( this , name);
        setUnlocalizedName(name);
        setMaxStackSize(64);
    }

    public String getName() {
        return name;
    }
}
