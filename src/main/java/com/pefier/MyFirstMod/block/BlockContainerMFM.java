package com.pefier.MyFirstMod.block;

import com.pefier.MyFirstMod.creativtab.CreativeTabMFM;
import com.pefier.MyFirstMod.reference.Reference;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by New Profile on 22.03.2016.
 */
public abstract class BlockContainerMFM extends BlockContainer {


    protected BlockContainerMFM(Material materialIn) {
        super(materialIn);
        setCreativeTab(CreativeTabMFM.MY_TAB);
    }

    @Override
    public abstract TileEntity createNewTileEntity(World worldIn, int meta);

    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }


}
