package com.pefier.MyFirstMod.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Pefier on 10.03.2016.
 */
public class ItemRingCold extends ItemMFM{
    public final String name ="RingCold";

    public ItemRingCold(){
        super();
        GameRegistry.registerItem( this , name);
        setUnlocalizedName(name);
    }
    public String getName(){
        return name;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn){







        return super.onItemRightClick(itemStackIn, worldIn, playerIn);
    }
}
