package com.pefier.MyFirstMod.handler;

import com.pefier.MyFirstMod.init.ModBlocks;
import com.pefier.MyFirstMod.utility.GenerationHelper;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

/**
 * Created by New Profile on 05.05.2016.
 */
public class WorldGenerator implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        int x = chunkX*16;
        int z = chunkZ*16;

        switch (world.provider.getDimension()){
            case -1:
                nether(random,x,z,world);
                break;
            case 1:
                theEnd(random,x,z,world);
                break;
            case 0:
                overWorld(random,x,z,world);
                break;


        }
    }

    private void nether(Random random,int x , int z , World world){

    }
    private void overWorld(Random random,int x , int z , World world){
        GenerationHelper.generateOre(ModBlocks.powerCristallOre.getDefaultState(), Blocks.stone,random,x,z,world,20,0,20,1,5);



    }
    private void theEnd(Random random,int x , int z , World world){

    }
}
