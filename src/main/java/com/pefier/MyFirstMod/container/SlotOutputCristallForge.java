package com.pefier.MyFirstMod.container;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by New Profile on 20.04.2016.
 */
public class SlotOutputCristallForge extends Slot {
    public SlotOutputCristallForge(IInventory inventoryIn, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);
    }

    public boolean isItemValid(ItemStack stack){ return false;}
}
