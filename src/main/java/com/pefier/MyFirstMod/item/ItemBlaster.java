package com.pefier.MyFirstMod.item;

import com.pefier.MyFirstMod.entity.throwabel.EntityLaser;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by New Profile on 13.04.2016.
 */
public class ItemBlaster extends ItemMFM {

    private static final String name = "Blaster";

    public ItemBlaster(){
        super();
        GameRegistry.registerItem(this,name);
        setMaxStackSize(1);
        setUnlocalizedName(name);

    }

    public static String getName() {
        return name;
    }
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
        worldIn.playSoundAtEntity(playerIn, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!worldIn.isRemote)
        {
            worldIn.spawnEntityInWorld(new EntityLaser(worldIn, playerIn));
        }

        return itemStackIn;
    }
}
