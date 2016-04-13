package com.pefier.MyFirstMod.init;

import com.pefier.MyFirstMod.MyFirstMod;
import com.pefier.MyFirstMod.entity.living.EntityCreator;
import com.pefier.MyFirstMod.entity.living.EntityRedPanda;
import com.pefier.MyFirstMod.entity.throwabel.EntityLaser;
import com.pefier.MyFirstMod.reference.Reference;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by New Profile on 07.03.2016.
 */
public class ModEntitys {

    public static void init(){


        EntityCreator.createEntity(EntityRedPanda.class, 1 , "RedPanda", EnumCreatureType.AMBIENT, 5,0,2, new BiomeGenBase[] {BiomeGenBase.birchForest,BiomeGenBase.beach});
        EntityRegistry.registerModEntity(EntityLaser.class,"laser",2, MyFirstMod.instance,32,1,true);
    }
}
