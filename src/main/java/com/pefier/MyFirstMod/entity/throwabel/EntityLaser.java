package com.pefier.MyFirstMod.entity.throwabel;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

/**
 * Created by New Profile on 13.04.2016.
 */
public class EntityLaser extends EntityThrowable {
    public EntityLaser(World worldIn) {
        super(worldIn);
    }

    public EntityLaser(World worldIn, EntityLivingBase throwerIn) {
        super(worldIn, throwerIn);
    }

    public EntityLaser(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }

    @Override
    protected void onImpact(MovingObjectPosition position) {
        System.out.println("landed");
        if(position.entityHit != null){


        }
    }
    @Override
    protected float getVelocity()
    {
        return 1.3F;
    }

    @Override
    protected float getGravityVelocity()
    {
        return 0.01F;
    }
}
