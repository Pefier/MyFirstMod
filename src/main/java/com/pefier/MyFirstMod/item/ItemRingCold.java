package com.pefier.MyFirstMod.item;

import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Pefier on 10.03.2016.
 */
public class ItemRingCold extends ItemMFM{
    public final String name ="RingCold";

    public ItemRingCold(){
        GameRegistry.registerItem( this , name);
        setUnlocalizedName(name);
    }
    public String getName(){
        return name;
    }
}
