package com.pefier.MyFirstMod.entity.living;


import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.world.World;

/**
 * Created by New Profile on 06.03.2016.
 */
public class EntityRedPanda extends EntityTameable {
    public EntityRedPanda(World worldIn) {
        super(worldIn);
        this.setSize(0.6F, 0.8F);
        this.stepHeight = 1.0F;
        ((PathNavigateGround)this.getNavigator()).setAvoidsWater(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 1.0D, true));
        this.tasks.addTask(5, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(6, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(9, new EntityAILookIdle(this));


    }
    @Override
    public void applyEntityAttributes(){
        super.applyEntityAttributes();
                getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2);
                getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32);
                getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10);


    }

    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return new EntityRedPanda(this.worldObj);
    }


}
