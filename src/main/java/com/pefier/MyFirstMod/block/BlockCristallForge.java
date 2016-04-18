package com.pefier.MyFirstMod.block;

import com.pefier.MyFirstMod.MyFirstMod;
import com.pefier.MyFirstMod.reference.Name;
import com.pefier.MyFirstMod.entity.tileEntity.TileCristallForge;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by New Profile on 07.04.2016.
 */
public class BlockCristallForge extends BlockContainerMFM {

    private static final String name = "CristallForge";

    public BlockCristallForge() {
        super(Material.piston);
        setUnlocalizedName(name);
        GameRegistry.registerBlock(this, name);
        GameRegistry.registerTileEntity(TileCristallForge.class,name);
        this.setHardness(1.5F);
        this.setResistance(2000F);


    }
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        if(!worldIn.isRemote){
            TileEntity tileEntity = worldIn.getTileEntity(pos);
            if(tileEntity instanceof TileCristallForge){
                playerIn.openGui(MyFirstMod.instance, Name.GuiIDs.GUI_CRISTALLFORGE,worldIn,pos.getX(),pos.getY(),pos.getZ());
            }
        }
        return false;
    }



    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileCristallForge();
    }

}
