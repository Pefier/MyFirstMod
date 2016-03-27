package com.pefier.MyFirstMod.render;

import com.pefier.MyFirstMod.init.ModItems;
import com.pefier.MyFirstMod.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

/**
 * Created by New Profile on 16.03.2016.
 */
public class ItemRenderRegister {


    public static void preInit() {
        ModelBakery.registerItemVariants(ModItems.ringFlash,new ModelResourceLocation(Reference.MOD_ID + ":RingFlash", "inventory"),new ModelResourceLocation(Reference.MOD_ID+ ":RingFlash1", "inventory"));
        ModelBakery.registerItemVariants(ModItems.ringGreenLantern,new ModelResourceLocation(Reference.MOD_ID +":RingLantern0","inventory"),new ModelResourceLocation(Reference.MOD_ID +":RingLantern1","inventory"));
    }

    public static void registerItemRenderer() {

        reg(ModItems.ringFlash, 0, "RingFlash");
        reg(ModItems.ringFlash, 1, "RingFlash1");
        reg(ModItems.ringGreenLantern,0,"RingLantern0");
        reg(ModItems.ringGreenLantern,1,"RingLantern1");

        reg(ModItems.flash_helm);
        reg(ModItems.flash_chest);
        reg(ModItems.flash_boots);
        reg(ModItems.flash_legs);
        reg(ModItems.bambus);
        reg(ModItems.pandaMeat);
        reg(ModItems.ringCold);


    }



    public static void reg(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getUnlocalizedName().substring(5), "inventory"));

    }

    public static void reg(Item item, int meta, String file) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(Reference.MOD_ID + ":" + file, "inventory"));
    }
}

