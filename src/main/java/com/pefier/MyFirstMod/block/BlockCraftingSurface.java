package com.pefier.MyFirstMod.block;

import com.pefier.MyFirstMod.MyFirstMod;
import com.pefier.MyFirstMod.reference.Name;
import com.pefier.MyFirstMod.reference.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by New Profile on 03.04.2016.
 */
public class BlockCraftingSurface extends BlockMFM {
    private static final String name="CraftingSurface";

    public BlockCraftingSurface(){
        super(Material.piston);
        setUnlocalizedName(name);
        this.setRegistryName(Reference.MOD_ID,name);
        GameRegistry.register(this);
        GameRegistry.register(new ItemBlock(this).setRegistryName(Reference.MOD_ID,name));
        this.setHardness(1.5F);
        this.setResistance(2000F);
    }
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        if(!playerIn.isSneaking()) {
            playerIn.openGui(MyFirstMod.instance, Name.GuiIDs.GUI_CRAFTING_SURFACE, worldIn, pos.getX(), pos.getY(), pos.getZ());
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }
}
