package com.pefier.MyFirstMod.Mob;

import com.pefier.MyFirstMod.init.ModItems;
import com.pefier.MyFirstMod.item.ItemBambus;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.world.World;

/**
 * Created by New Profile on 06.03.2016.
 */
public class EntityRedPanda extends EntityAnimal {
    public EntityRedPanda(World worldIn) {
        super(worldIn);

        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.25D, ModItems.bambus, false));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
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
