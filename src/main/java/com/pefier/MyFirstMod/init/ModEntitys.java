package com.pefier.MyFirstMod.init;

import com.pefier.MyFirstMod.MyFirstMod;
import com.pefier.MyFirstMod.entity.living.EntityRedPanda;
import com.pefier.MyFirstMod.entity.throwabel.EntityLaser;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.common.registry.EntityRegistry;

/**
 * Created by New Profile on 07.03.2016.
 */
public class ModEntitys {

    public static void init(){



        EntityRegistry.registerModEntity(EntityRedPanda.class, "RedPanda", 1, MyFirstMod.instance, 64, 1, true);
        EntityRegistry.registerModEntity(EntityLaser.class,"laser",2, MyFirstMod.instance,32,1,true);
        EntityRegistry.addSpawn(EntityRedPanda.class,2,1,4,EnumCreatureType.AMBIENT, new BiomeGenBase[] {BiomeGenBase.getBiome(30),BiomeGenBase.getBiome(31)});



    }
}
