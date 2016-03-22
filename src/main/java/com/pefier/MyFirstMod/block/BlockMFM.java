package com.pefier.MyFirstMod.block;

import com.pefier.MyFirstMod.creativtab.CreativeTabMFM;
import com.pefier.MyFirstMod.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by New Profile on 21.03.2016.
 */
public class BlockMFM extends Block{


    public BlockMFM(Material materialIn) {
        super(materialIn);
        this.setCreativeTab(CreativeTabMFM.MY_TAB);
    }

    public BlockMFM() {
        this(Material.rock);
    }

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



