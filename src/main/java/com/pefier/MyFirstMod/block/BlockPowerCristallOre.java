package com.pefier.MyFirstMod.block;

import com.pefier.MyFirstMod.init.ModItems;
import com.pefier.MyFirstMod.reference.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
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
        this.setRegistryName(Reference.MOD_ID,name);
        GameRegistry.register(this);
        GameRegistry.register(new ItemBlock(this).setRegistryName(Reference.MOD_ID,name));
        this.setHarvestLevel("pickaxe",3);
        this.setHardness(20.5F);
        this.setResistance(3000F);

    }

    public static String getName() {
        return name;
    }
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune){
        return ModItems.powerCristall;
    }

    @Override
    public int damageDropped(IBlockState state) {
        Random rnd =new Random();
        return rnd.nextInt(4);
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
