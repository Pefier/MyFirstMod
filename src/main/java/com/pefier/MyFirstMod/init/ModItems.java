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
    public static Item greenlantern_helm;
    public static Item greenlantern_chest;
    public static Item greenlantern_legs;
    public static Item greenlantern_boots;
    public static Item ringGreenLantern;

    public static void preinit(){

        //Normal Items
        bambus = new ItemBambus();
        pandaMeat = new ItemPandaMeat();
        ringFlash = new ItemRingFlash();
        ringCold = new ItemRingCold();
        ringGreenLantern = new ItemGreenLanterRing();
        //Armor Items
        ItemArmor.ArmorMaterial Hero = EnumHelper.addArmorMaterial("hero","", 0, new int[]{3, 8, 6, 3}, 0);

        flash_helm =new ItemFlashHelm(Hero,3,0);
        flash_chest = new ItemFlashBody(Hero, 3, 1);
        flash_legs = new ItemFlashLegs(Hero, 3, 2);
        flash_boots = new ItemFlashBoots(Hero, 3, 3);

        greenlantern_helm = new ItemGreenLanternHelm(Hero, 3,0);
        greenlantern_chest= new ItemGreenLanternBody(Hero,3,1);
        greenlantern_legs= new ItemGreenLanternLegs(Hero,3,2);
        greenlantern_boots= new ItemGreenLanternBoots(Hero,3,3);


    }
}
