package com.pefier.MyFirstMod.item;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by New Profile on 21.03.2016.
 */
public class ItemGreenLanternLegs extends ArmorMFM {

    final static private String name = "GreenLanternArmor_legs";

    public ItemGreenLanternLegs(ArmorMaterial material, int renderIndex) {
        super(material, renderIndex, EntityEquipmentSlot.LEGS);
        GameRegistry.registerItem(this, name);
        setUnlocalizedName(name);
    }

    public static String getName() {
        return name;
    }
}
