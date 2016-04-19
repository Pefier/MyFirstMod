package com.pefier.MyFirstMod.item;

import com.pefier.MyFirstMod.reference.Reference;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by New Profile on 13.03.2016.
 */
public class ItemFlashLegs extends ArmorMFM {
    private final String name = "FlashArmor_legs";
    public ItemFlashLegs(ArmorMaterial material, int renderIndex) {
        super(material, renderIndex, EntityEquipmentSlot.LEGS);
        this.setRegistryName(Reference.MOD_ID,name);
        GameRegistry.register(this);
        setUnlocalizedName(name);
    }

    public String getName() {
        return name;
    }
}
