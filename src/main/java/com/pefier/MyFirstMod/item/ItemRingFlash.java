package com.pefier.MyFirstMod.item;

import com.pefier.MyFirstMod.reference.Reference;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Pefier on 10.03.2016.
 */
public class ItemRingFlash extends Item {
    public final String name ="RingFlash";
    public ItemRingFlash(){

        GameRegistry.registerItem( this , name);
        setUnlocalizedName(Reference.MOD_ID + ":" + name);
    }
    public String getName(){
        return name;
    }
}
