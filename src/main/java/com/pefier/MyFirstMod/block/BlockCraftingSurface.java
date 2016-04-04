package com.pefier.MyFirstMod.block;

import com.pefier.MyFirstMod.MyFirstMod;
import com.pefier.MyFirstMod.reference.Name;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
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
        GameRegistry.registerBlock(this,name);
        this.setHardness(1.5F);
        this.setResistance(2000F);
    }
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
        if(!playerIn.isSneaking()) {
            playerIn.openGui(MyFirstMod.instance, Name.GuiIDs.GUI_CRAFTING_SURFACE, worldIn, pos.getX(), pos.getY(), pos.getZ());
            return true;
        }else{
            return false;
        }
    }


}
