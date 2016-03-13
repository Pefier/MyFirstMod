package com.pefier.MyFirstMod.proxy;

import java.util.HashMap;
import java.util.Map;

import com.pefier.MyFirstMod.amorModels.ModelFlashArmor;
import com.pefier.MyFirstMod.init.ModItems;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.Item;

/**
 * Created by New Profile on 06.03.2016.
 */
public class ClientProxy extends CommonProxy {
    public static final Map<Item, ModelBiped> armorModels = new HashMap<Item, ModelBiped>();

    public static void register_renderers(){

        ModelFlashArmor FlashArmor_armor = new ModelFlashArmor(0.5F);
        ModelFlashArmor FlashArmor_legs = new ModelFlashArmor(0.2F);

        armorModels.put(ModItems.flash_helm, FlashArmor_armor);
        armorModels.put(ModItems.flash_chest, FlashArmor_armor);
        armorModels.put(ModItems.flash_legs, FlashArmor_legs);
        armorModels.put(ModItems.flash_boots, FlashArmor_armor);

    }
}
