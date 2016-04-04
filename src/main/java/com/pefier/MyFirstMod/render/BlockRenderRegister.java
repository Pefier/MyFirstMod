package com.pefier.MyFirstMod.render;

import com.pefier.MyFirstMod.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

/**
 * Created by New Profile on 21.03.2016.
 */
public class BlockRenderRegister {

    public static void registerBlockRenderer() {
        reg(ModBlocks.charger);
        reg(ModBlocks.powerCristallOre);
        reg(ModBlocks.craftingSurface);
    }

    public static void reg(Block block) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getUnlocalizedName().substring(5), "inventory"));
    }
}
