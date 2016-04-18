package com.pefier.MyFirstMod.utility;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by New Profile on 27.03.2016.
 */
public class InventoryHelper {



    public static ItemStack getItemStackinInventory(EntityPlayer player, Item item) {
        ItemStack stack = new ItemStack(item);
        if (player.inventory.hasItemStack(stack)) {
            for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
                if (player.inventory.getStackInSlot(i) != null && player.inventory.getStackInSlot(i).getItem() == stack.getItem()) {
                    return player.inventory.getStackInSlot(i);
                }
            }
        }
        return null;
    }
}
