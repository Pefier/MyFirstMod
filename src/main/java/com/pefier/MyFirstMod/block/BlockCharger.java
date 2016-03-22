package com.pefier.MyFirstMod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by New Profile on 21.03.2016.
 */
public class BlockCharger extends BlockMFM {

    private static final String name="charger";

    public BlockCharger(Material materialIn) {
        super(materialIn);
        setUnlocalizedName(name);
        GameRegistry.registerBlock(this,name);
        this.setHardness(1.5F);
        this.setResistance(2000F);
    }

    public static String getName() {
        return name;
    }
}
