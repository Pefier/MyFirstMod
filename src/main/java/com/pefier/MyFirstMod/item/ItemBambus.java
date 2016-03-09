package com.pefier.MyFirstMod.item;

import com.pefier.MyFirstMod.reference.Reference;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by New Profile on 07.03.2016.
 */
public class ItemBambus extends Item {

    private final String name = "Bambus";

    public ItemBambus(){

        GameRegistry.registerItem( this , name);
        setUnlocalizedName(Reference.MOD_ID + ":" + name);
        setMaxStackSize(64);
    }

    public String getName(){
        return name;
    }
}
