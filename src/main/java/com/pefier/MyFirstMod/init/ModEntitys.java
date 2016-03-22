package com.pefier.MyFirstMod.init;

import com.pefier.MyFirstMod.Mob.EntityCreator;
import com.pefier.MyFirstMod.Mob.EntityRedPanda;
import com.pefier.MyFirstMod.client.entityrender.RenderRedPanda;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

/**
 * Created by New Profile on 07.03.2016.
 */
public class ModEntitys {

    public static void init(){


        EntityCreator.createEntity(EntityRedPanda.class, 1 , "RedPanda", EnumCreatureType.AMBIENT, 5,0,2, new BiomeGenBase[] {BiomeGenBase.birchForest,BiomeGenBase.beach});

    }
}
