package com.pefier.MyFirstMod.item;


import com.pefier.MyFirstMod.reference.Reference;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by New Profile on 07.03.2016.
 */
public class ItemBambus extends ItemMFM {

    private final String name = "Bambus";

    public ItemBambus(){
        super();
        this.setRegistryName(Reference.MOD_ID,name);
        GameRegistry.register(this);
        setUnlocalizedName(name);
        setMaxStackSize(64);
    }

    public String getName() {
        return name;
    }
}
