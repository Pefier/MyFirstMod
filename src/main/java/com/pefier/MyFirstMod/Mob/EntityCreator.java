package com.pefier.MyFirstMod.Mob;

import com.pefier.MyFirstMod.MyFirstMod;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

/**
 * Created by New Profile on 07.03.2016.
 */
public class EntityCreator {
    public static final void createEntity(Class entityClass, int id, String entityName, EnumCreatureType type, int probability, int minSpwan, int maxSpawn, BiomeGenBase[] biomes){

        EntityRegistry.registerModEntity(entityClass, entityName, id, MyFirstMod.instance, 64, 1, true);
        EntityRegistry.addSpawn(entityClass,probability,minSpwan,maxSpawn,type, biomes);
    }
}
