package com.pefier.MyFirstMod.item;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by New Profile on 13.03.2016.
 */
public class ItemFlashLegs extends ArmorMFM {
    private final String name = "FlashArmor_legs";
    public ItemFlashLegs(ArmorMaterial material, int renderIndex) {
        super(material, renderIndex, EntityEquipmentSlot.LEGS);
        GameRegistry.registerItem( this ,name);
        setUnlocalizedName(name);
    }

    public String getName() {
        return name;
    }
}
