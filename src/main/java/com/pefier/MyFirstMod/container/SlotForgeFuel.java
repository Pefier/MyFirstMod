package com.pefier.MyFirstMod.container;

import com.pefier.MyFirstMod.entity.tileEntity.TileCristallForge;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;

/**
 * Created by New Profile on 20.04.2016.
 */
public class SlotForgeFuel extends Slot {
    public SlotForgeFuel(IInventory inventoryIn, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);
    }
    @Override
    public boolean isItemValid(ItemStack stack){
        return TileEntityFurnace.isItemFuel(stack);
    }
}
