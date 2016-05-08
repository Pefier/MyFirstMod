package com.pefier.MyFirstMod.block;

import com.pefier.MyFirstMod.MyFirstMod;
import com.pefier.MyFirstMod.reference.Name;
import com.pefier.MyFirstMod.entity.tileEntity.TileCristallForge;
import com.pefier.MyFirstMod.reference.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

/**
 * Created by New Profile on 07.04.2016.
 */
public class BlockCristallForge extends BlockContainerMFM {

    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
    private static final String name = "CristallForge";

    public BlockCristallForge() {
        super(Material.piston);
        setUnlocalizedName(name);
        this.setRegistryName(Reference.MOD_ID,name);
        GameRegistry.register(this);
        GameRegistry.register(new ItemBlock(this).setRegistryName(Reference.MOD_ID,name));
        GameRegistry.registerTileEntity(TileCristallForge.class,name);
        this.setHardness(1.5F);
        this.setResistance(2000F);
        this.setDefaultState(makeDefaultState());

    }
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!playerIn.isSneaking()) {
            if (!worldIn.isRemote) {
                TileEntity tileEntity = worldIn.getTileEntity(pos);
                if (tileEntity instanceof TileCristallForge) {
                    playerIn.openGui(MyFirstMod.instance, Name.GuiIDs.GUI_CRISTALLFORGE, worldIn, pos.getX(), pos.getY(), pos.getZ());
                }
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {

            TileEntity tileentity = worldIn.getTileEntity(pos);

            if (tileentity instanceof TileCristallForge)
            {
                InventoryHelper.dropInventoryItems(worldIn, pos, (TileCristallForge)tileentity);
                worldIn.updateComparatorOutputLevel(pos, this);
            }

        super.breakBlock(worldIn, pos, state);
    }


    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileCristallForge();
    }


    public String getName() {
        return this.name;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    //FACING


    public IBlockState makeDefaultState(){
        return blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH);
    }

    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state){
        setDefaultFacing(world, pos, state);
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
    }


    private void setDefaultFacing(World world, BlockPos pos, IBlockState thisState) {
        if(!world.isRemote) {
            IBlockState state = world.getBlockState(pos.north());
            IBlockState state1 = world.getBlockState(pos.south());
            IBlockState state2 = world.getBlockState(pos.west());
            IBlockState state3 = world.getBlockState(pos.east());
            EnumFacing enumfacing = thisState.getValue(FACING);

            if(enumfacing == EnumFacing.NORTH && state.isFullBlock() && !state1.isFullBlock())
                enumfacing = EnumFacing.SOUTH;
            else if(enumfacing == EnumFacing.SOUTH && state1.isFullBlock() && !state.isFullBlock())
                enumfacing = EnumFacing.NORTH;
            else if(enumfacing == EnumFacing.WEST && state2.isFullBlock() && !state3.isFullBlock())
                enumfacing = EnumFacing.EAST;
            else if(enumfacing == EnumFacing.EAST && state3.isFullBlock() && !state2.isFullBlock())
                enumfacing = EnumFacing.WEST;

            world.setBlockState(pos, thisState.withProperty(FACING, enumfacing), 2);
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing enumfacing = EnumFacing.getFront(meta);

        if (enumfacing.getAxis() == EnumFacing.Axis.Y)
        {
            enumfacing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(FACING, enumfacing);
    }
    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FACING});
    }


    @Override
    public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand) {

        //X
        float f1 = (float)pos.getX() + 0.9F;
        //z
        float f2 = (float)pos.getZ() + 0.75F;

        float r1 = rand.nextFloat() * 0.3F -0.3F;
        float r2 = rand.nextFloat() * 0.3F -0.3F;

        float f8 = (float)pos.getY() + 0.7F;
        float f9 = (float)pos.getY() + 0.5F;
        float f10 = (float)pos.getY() + 0.6F;

        //X
        float f11 = (float)pos.getX() + 0.9F;
        //Z
        float f12 = (float)pos.getZ() + 0.75F;


        if(world.getTileEntity(pos) instanceof TileCristallForge) {
           if (((TileCristallForge) world.getTileEntity(pos)).canForge()&& ((TileCristallForge) world.getTileEntity(pos)).isForging()) {
                world.spawnParticle(EnumParticleTypes.SUSPENDED_DEPTH, (double) (f1+r1), (double)f9, (double)(f2+r2), 0.0D, 0.0D, 0.0D);
                world.spawnParticle(EnumParticleTypes.SUSPENDED_DEPTH, (double) (f1+r1), (double)f10, (double)(f2+r2), 0.0D, 0.0D, 0.0D);
                world.spawnParticle(EnumParticleTypes.SUSPENDED_DEPTH, (double) (f1+r1), (double)f8, (double)(f2+r2), 0.0D, 0.0D, 0.0D);

                world.spawnParticle(EnumParticleTypes.SUSPENDED_DEPTH, (double) (f11 + r1), (double) f9, (double) (f12 + r2), 0.0D, 0.0D, 0.0D);
                world.spawnParticle(EnumParticleTypes.SUSPENDED_DEPTH, (double) (f11 + r1), (double) f10, (double) (f12 + r2), 0.0D, 0.0D, 0.0D);
                world.spawnParticle(EnumParticleTypes.SUSPENDED_DEPTH, (double) (f11 + r1), (double) f8, (double) (f12 + r2), 0.0D, 0.0D, 0.0D);


           }
        }



    }
}
