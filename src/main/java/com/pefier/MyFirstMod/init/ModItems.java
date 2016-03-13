package com.pefier.MyFirstMod.init;

import com.pefier.MyFirstMod.amor.ArmorMFM;
import com.pefier.MyFirstMod.item.*;
import com.pefier.MyFirstMod.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by New Profile on 07.03.2016.
 */
public class ModItems {

    public static Item bambus;
    public static Item pandaMeat;
    public static Item ringFlash;
    public static Item ringCold;
    public static Item flash_helm;
    public static Item flash_chest;
    public static Item flash_legs;
    public static Item flash_boots;


    public static void preinit(){

        //Normal Items
        bambus = new ItemBambus();
        pandaMeat = new ItemPandaMeat();
        ringFlash = new ItemRingFlash();
        ringCold = new ItemRingCold();
        //Armor Items
        ItemArmor.ArmorMaterial Useless = EnumHelper.addArmorMaterial("useless","", 0, new int[]{0, 0, 0, 0}, 0);

        flash_helm =new ItemFlashHelm(Useless,1,0);
        flash_chest = new ItemFlashBody(Useless, 1, 1);
        flash_legs = new ItemFlashLegs(Useless, 1, 2);
        flash_boots = new ItemFlashBoots(Useless, 1, 3);


    }

    public static void init(){
        //initializing item rendering
        RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

        renderItem.getItemModelMesher().register(bambus , 0, new ModelResourceLocation(Reference.MOD_ID + ":" + ((ItemBambus) bambus).getName(), "inventory"));
        renderItem.getItemModelMesher().register(pandaMeat , 0, new ModelResourceLocation(Reference.MOD_ID + ":" + ((ItemPandaMeat) pandaMeat).getName(), "inventory"));
        renderItem.getItemModelMesher().register(ringFlash , 0, new ModelResourceLocation(Reference.MOD_ID + ":" + ((ItemRingFlash) ringFlash).getName(), "inventory"));
        renderItem.getItemModelMesher().register(ringCold , 0, new ModelResourceLocation(Reference.MOD_ID + ":" + ((ItemRingCold) ringCold).getName(), "inventory"));






    }
}
