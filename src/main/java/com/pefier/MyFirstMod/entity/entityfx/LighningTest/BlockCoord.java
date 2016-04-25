package com.pefier.MyFirstMod.entity.entityfx.LighningTest;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by New Profile on 24.04.2016.
 */
public class BlockCoord implements Comparable<BlockCoord>{
    private int x;
    private int y;
    private int z;

    public BlockCoord(int x, int y, int z) {
        this.x=x;
        this.y=y;
        this.z=z;

    }

    public BlockCoord(TileEntity tile) {

        this.x=tile.getPos().getX();
        this.y= tile.getPos().getY();
        this.z= tile.getPos().getZ();
    }

    @Override
    public int compareTo(BlockCoord o) {
        if (x != o.x)
            return x < o.x ? 1 : -1;
        if (y != o.y)
            return y < o.y ? 1 : -1;
        if (z != o.z)
            return z < o.z ? 1 : -1;
        return 0;
    }

    public Vector3 toVector3Centered() {
        return new Vector3(x + 0.5, y + 0.5, z + 0.5);
    }
}
