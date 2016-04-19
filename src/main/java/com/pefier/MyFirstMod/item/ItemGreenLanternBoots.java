package com.pefier.MyFirstMod.item;

import com.pefier.MyFirstMod.reference.Reference;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by New Profile on 21.03.2016.
 */
public class ItemGreenLanternBoots extends ArmorMFM {

    final static private String name = "GreenLanternArmor_boots";

    public ItemGreenLanternBoots(ArmorMaterial material, int renderIndex) {
        super(material, renderIndex, EntityEquipmentSlot.FEET);
        this.setRegistryName(Reference.MOD_ID,name);
        GameRegistry.register(this);
        setUnlocalizedName(name);
    }

    public static String getName() {
        return name;
    }
}
