package com.pefier.MyFirstMod.container;

import com.pefier.MyFirstMod.init.ModItems;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by New Profile on 19.04.2016.
 */
public class SlotGreenCristall extends Slot {
    public SlotGreenCristall(IInventory inventoryIn, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        if(stack.getItem()== ModItems.powerCristallUnlocked && stack.getMetadata() == 2){
            return true;
        }else {
            return false;
        }
    }
}
