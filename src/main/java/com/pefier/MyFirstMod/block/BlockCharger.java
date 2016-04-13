package com.pefier.MyFirstMod.block;

import com.pefier.MyFirstMod.MyFirstMod;
import com.pefier.MyFirstMod.reference.Name;
import com.pefier.MyFirstMod.entity.tileEntity.TileCharger;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by New Profile on 21.03.2016.
 */
public class BlockCharger extends BlockContainerMFM {

    private static final String name="charger";

    public BlockCharger() {
        super(Material.piston);
        setUnlocalizedName(name);
        GameRegistry.registerBlock(this, name);
        GameRegistry.registerTileEntity(TileCharger.class,name);
        this.setHardness(1.5F);
        this.setResistance(2000F);

    }

    public static String getName() {
        return name;
    }




    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
        if(!worldIn.isRemote){
            TileEntity tileEntity = worldIn.getTileEntity(pos);
            if(tileEntity instanceof TileCharger){
                playerIn.openGui(MyFirstMod.instance, Name.GuiIDs.GUI_CHARGER,worldIn,pos.getX(),pos.getY(),pos.getZ());
            }
        }
            return false;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileCharger();
    }
    @Override
    public int getRenderType() {
        return 3;
    }

}
