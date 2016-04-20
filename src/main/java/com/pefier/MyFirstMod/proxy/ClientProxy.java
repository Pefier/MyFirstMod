package com.pefier.MyFirstMod.proxy;

import java.util.HashMap;
import java.util.Map;

import com.pefier.MyFirstMod.amorModels.ModelFlashArmor;
import com.pefier.MyFirstMod.amorModels.ModelGreenLanternArmor;
import com.pefier.MyFirstMod.client.handler.ModSoundHandler;
import com.pefier.MyFirstMod.client.registry.ModKeyBindings;
import com.pefier.MyFirstMod.init.ModItems;
import com.pefier.MyFirstMod.render.BlockRenderRegister;
import com.pefier.MyFirstMod.render.EntityRenderRegister;
import com.pefier.MyFirstMod.render.ItemRenderRegister;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by New Profile on 06.03.2016.
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        ItemRenderRegister.preInit();
        EntityRenderRegister.preinit();
        ModKeyBindings.RegisterKeyBindings();
        ModSoundHandler.init();

    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);

        ItemRenderRegister.registerItemRenderer();
        BlockRenderRegister.registerBlockRenderer();
        register_renderers();

    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }

    public static final Map<Item, ModelBiped> armorModels = new HashMap<Item, ModelBiped>();

    public static void register_renderers(){

        ModelFlashArmor FlashArmor_armor = new ModelFlashArmor(0.5F);
        ModelFlashArmor FlashArmor_legs = new ModelFlashArmor(0.2F);

        armorModels.put(ModItems.flash_helm, FlashArmor_armor);
        armorModels.put(ModItems.flash_chest, FlashArmor_armor);
        armorModels.put(ModItems.flash_legs, FlashArmor_legs);
        armorModels.put(ModItems.flash_boots, FlashArmor_armor);

        ModelGreenLanternArmor GreenLanternArmor_armor = new ModelGreenLanternArmor(0.5F);
        ModelGreenLanternArmor GreenLanternArmor_legs = new ModelGreenLanternArmor(0.2F);

        armorModels.put(ModItems.greenlantern_helm, GreenLanternArmor_armor);
        armorModels.put(ModItems.greenlantern_chest, GreenLanternArmor_armor);
        armorModels.put(ModItems.greenlantern_legs, GreenLanternArmor_legs);
        armorModels.put(ModItems.greenlantern_boots, GreenLanternArmor_armor);

    }
}
