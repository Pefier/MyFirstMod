package com.pefier.MyFirstMod.block;

import com.pefier.MyFirstMod.init.ModItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

/**
 * Created by New Profile on 28.03.2016.
 */
public class BlockPowerCristallOre extends BlockMFM {
    private static final String name="PowerCristallOre";
    public BlockPowerCristallOre(){
        super(Material.rock);
        setUnlocalizedName(name);
        GameRegistry.registerBlock(this,name);
        this.setHardness(1.5F);
        this.setResistance(2000F);

    }

    public static String getName() {
        return name;
    }
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune){

        switch (rand.nextInt(3)){
            case 0: return ModItems.powerCristall;
            case 1: return ModItems.powerCristall;
            case 2: return ModItems.powerCristall;
            case 3: return ModItems.powerCristall;
            default:return null;
        }

    }
    @Override
    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        return this.quantityDropped(random) + random.nextInt(fortune + 1);
    }

    @Override
    public int quantityDropped(Random random)
    {
        return 1 + random.nextInt(2);
    }
}
