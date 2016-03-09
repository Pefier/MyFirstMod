package com.pefier.MyFirstMod.init;

import com.pefier.MyFirstMod.item.ItemBambus;
import com.pefier.MyFirstMod.item.ItemPandaMeat;
import com.pefier.MyFirstMod.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by New Profile on 07.03.2016.
 */
public class ModItems {

    public static Item bambus;
    public static Item pandaMeat;

    public static void preinit(){
        bambus = new ItemBambus();
        pandaMeat = new ItemPandaMeat();

    }

    public static void init(){
        //initializing item rendering
        RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

        renderItem.getItemModelMesher().register(bambus , 0, new ModelResourceLocation(Reference.MOD_ID + ":" + ((ItemBambus) bambus).getName(), "inventory"));
        renderItem.getItemModelMesher().register(pandaMeat , 0, new ModelResourceLocation(Reference.MOD_ID + ":" + ((ItemPandaMeat) pandaMeat).getName(), "inventory"));


    }
}
