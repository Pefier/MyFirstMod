package com.pefier.MyFirstMod.item;

import com.pefier.MyFirstMod.creativtab.CreativeTabMFM;
import com.pefier.MyFirstMod.reference.Reference;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by New Profile on 07.03.2016.
 */
public class ItemPandaMeat extends ItemMFM{

    public final String name = "PandaMeat";

    public ItemPandaMeat(){
        super();
        this.setRegistryName(Reference.MOD_ID,name);
        GameRegistry.register(this);
        setUnlocalizedName(name);
    }
    public String getName(){
        return name;
    }

}
