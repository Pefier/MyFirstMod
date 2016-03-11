package com.pefier.MyFirstMod.item;

import com.pefier.MyFirstMod.creativtab.CreativeTabMFM;
import com.pefier.MyFirstMod.reference.Reference;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Pefier on 10.03.2016.
 */
public class ItemRingCold extends Item{
    public final String name ="RingCold";

    public ItemRingCold(){
        GameRegistry.registerItem( this , name);
        setUnlocalizedName(Reference.MOD_ID + ":" + name);
        this.setCreativeTab(CreativeTabMFM.MY_TAB);

    }
    public String getName(){
        return name;
    }
}
