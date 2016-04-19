package com.pefier.MyFirstMod.item;

import com.pefier.MyFirstMod.reference.Reference;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by New Profile on 21.03.2016.
 */
public class ItemGreenLanternBody extends ArmorMFM {

    final static private String name = "GreenLanternArmor_chest";

    public ItemGreenLanternBody(ArmorMaterial material, int renderIndex) {
        super(material, renderIndex, EntityEquipmentSlot.CHEST);
        this.setRegistryName(Reference.MOD_ID,name);
        GameRegistry.register(this);
        setUnlocalizedName(name);
    }

    public static String getName() {
        return name;
    }
}
