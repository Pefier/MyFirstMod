package com.pefier.MyFirstMod.item;

import com.pefier.MyFirstMod.amor.ArmorMFM;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by New Profile on 21.03.2016.
 */
public class ItemGreenLanternBoots extends ArmorMFM {

    final static private String name = "GreenLanternArmor_boots";

    public ItemGreenLanternBoots(ArmorMaterial material, int renderIndex, int armorType) {
        super(material, renderIndex, armorType);
        GameRegistry.registerItem(this, name);
        setUnlocalizedName(name);
    }

    public static String getName() {
        return name;
    }
}
