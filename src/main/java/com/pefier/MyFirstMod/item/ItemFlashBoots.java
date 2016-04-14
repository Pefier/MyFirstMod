package com.pefier.MyFirstMod.item;

import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by New Profile on 13.03.2016.
 */
public class ItemFlashBoots extends ArmorMFM{

    private final String name ="FlashArmor_boots";

    public ItemFlashBoots(ArmorMaterial material, int renderIndex, int armorType) {
        super(material, renderIndex, armorType);
        GameRegistry.registerItem( this ,name);
        setUnlocalizedName(name);

    }

    public String getName() {
        return name;
    }
}
