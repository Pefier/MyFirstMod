package com.pefier.MyFirstMod.init;

import com.pefier.MyFirstMod.block.BlockCharger;
import com.pefier.MyFirstMod.block.BlockCraftingSurface;
import com.pefier.MyFirstMod.block.BlockCristallForge;
import com.pefier.MyFirstMod.block.BlockPowerCristallOre;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.biome.BiomeCache;

/**
 * Created by New Profile on 21.03.2016.
 */
public class ModBlocks {

    public static Block charger;
    public static Block powerCristallOre;
    public static Block craftingSurface;
    public static Block cristallForge;
    public static void preinit(){
        charger = new BlockCharger();
        powerCristallOre = new BlockPowerCristallOre();
        craftingSurface = new BlockCraftingSurface();
        cristallForge = new BlockCristallForge();
    }
}
