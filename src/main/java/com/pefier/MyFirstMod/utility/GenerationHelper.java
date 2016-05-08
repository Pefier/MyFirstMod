package com.pefier.MyFirstMod.utility;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

/**
 * Created by New Profile on 05.05.2016.
 */
public class GenerationHelper {

    public static void generateOre(IBlockState iBlockState, Block blockin, Random random, int x , int z, World world, int  chance, int minY , int maxY, int minVineSize, int maxVineSize){

        int vineSize = minVineSize+ random.nextInt(maxVineSize-minVineSize);
        int hightRange = maxY-minY;

        for(int i=0; i<chance; i++){
            int posX = x + random.nextInt(16);
            int posY = random.nextInt(hightRange)+ minY;
            int posZ = z + random.nextInt(16);

            new WorldGenMinable(iBlockState,vineSize, BlockMatcher.forBlock(blockin)).generate(world,random,new BlockPos(posX,posY,posZ));
        }

    }
}
