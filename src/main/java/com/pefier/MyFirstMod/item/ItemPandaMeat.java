package com.pefier.MyFirstMod.item;

import com.pefier.MyFirstMod.reference.Reference;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by New Profile on 07.03.2016.
 */
public class ItemPandaMeat extends Item{

    public final String name = "PandaMeat";

    public ItemPandaMeat(){

        GameRegistry.registerItem( this , name);
        setUnlocalizedName(Reference.MOD_ID + ":" + name);
    }
    public String getName(){
        return name;
    }

}
