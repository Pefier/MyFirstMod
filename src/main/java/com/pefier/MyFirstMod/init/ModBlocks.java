package com.pefier.MyFirstMod.init;

import com.pefier.MyFirstMod.block.BlockCharger;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.biome.BiomeCache;

/**
 * Created by New Profile on 21.03.2016.
 */
public class ModBlocks {

    public static Block charger;

    public static void preinit(){
        charger = new BlockCharger(Material.piston);


    }
}
