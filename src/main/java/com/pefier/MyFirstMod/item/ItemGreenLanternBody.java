package com.pefier.MyFirstMod.item;

import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by New Profile on 21.03.2016.
 */
public class ItemGreenLanternBody extends ArmorMFM {

    final static private String name = "GreenLanternArmor_chest";

    public ItemGreenLanternBody(ArmorMaterial material, int renderIndex, int armorType) {
        super(material, renderIndex, armorType);
        GameRegistry.registerItem(this, name);
        setUnlocalizedName(name);
    }

    public static String getName() {
        return name;
    }
}
