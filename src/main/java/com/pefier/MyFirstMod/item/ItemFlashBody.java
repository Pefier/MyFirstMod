package com.pefier.MyFirstMod.item;

import com.pefier.MyFirstMod.reference.Reference;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by New Profile on 13.03.2016.
 */
public class ItemFlashBody extends ArmorMFM {

    private final String name = "FlashArmor_chest" ;

    public ItemFlashBody(ArmorMaterial material, int renderIndex) {
        super(material, renderIndex, EntityEquipmentSlot.CHEST);
        this.setRegistryName(Reference.MOD_ID,name);
        GameRegistry.register(this);
        setUnlocalizedName(name);
    }
    public String getName(){
        return name;
    }

}
