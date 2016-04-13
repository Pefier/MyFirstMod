package com.pefier.MyFirstMod.container;

import com.pefier.MyFirstMod.init.ModItems;
import com.pefier.MyFirstMod.entity.tileEntity.TileCristallForge;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by New Profile on 07.04.2016.
 */
public class ContainerCirstallForge extends Container{

    private TileCristallForge forge;

    private int lastProgressTime;

    public static final int INPUT[] = {0,1};

    public static final int FUEL = INPUT.length;
    public static final int OUTPUT = INPUT.length+1;
    public static final int INV_START = OUTPUT+1;
    public static final int INV_END = INV_START+26;
    public static final int HOTBAR_START = INV_END+1;
    public static final int HOTBAR_END= HOTBAR_START+8;
    private int totalForgeTime;
    private int forgeBurnTime;
    private int forgeTime;
    public int currentItemForgeBurnTime;



    public ContainerCirstallForge(InventoryPlayer playerInv, TileCristallForge cristallForge){
        this.forge = cristallForge;
        int index=0;
        int i ;
        int j ;
        int k;

        this.addSlotToContainer(new Slot(cristallForge,index++, 32,23 ));
        this.addSlotToContainer(new Slot(cristallForge,index++, 50 ,23 ));
        this.addSlotToContainer(new Slot(cristallForge,index++, 40, 46));
        this.addSlotToContainer(new Slot(cristallForge,index++, 131, 33));

        //playerInventory
        i = -18;
        for (j = 0; j < 9; ++j) {
            this.addSlotToContainer(new Slot(playerInv, j, 8 + j * 18, 160 + i));

        }

        for (j = 0; j < 3; ++j){
            for (k = 0; k < 9; ++k) {
                this.addSlotToContainer(new Slot(playerInv, k + j * 9 + 9, 8 + k * 18, 102 + j * 18 + i));

            }
        }

    }




    @Override
    public void detectAndSendChanges() {
      super.detectAndSendChanges();

      for (int i = 0; i < this.crafters.size(); ++i) {

          ICrafting icrafting = (ICrafting) this.crafters.get(i);

          if (this.forgeTime != forge.getField(2)) {

              icrafting.sendProgressBarUpdate(this, 2, forge.getField(2));
          }

          if (this.forgeBurnTime!= forge.getField(0)) {
              icrafting.sendProgressBarUpdate(this, 0, forge.getField(0));
          }
          if (this.currentItemForgeBurnTime!= forge.getField(1)){
              icrafting.sendProgressBarUpdate(this,1,forge.getField(1));
          }

          if (this.totalForgeTime != forge.getField(3)) {
              icrafting.sendProgressBarUpdate(this, 3, forge.getField(3));
          }


      }
      this.forgeTime = this.forge.getField(2);
      this.forgeBurnTime = this.forge.getField(0);
      this.currentItemForgeBurnTime = this.forge.getField(1);
      this.totalForgeTime = this.forge.getField(3);

    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data)
    {
       forge.setField(id,data);
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {

        return forge.isUseableByPlayer(playerIn);
    }

    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int index)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index < INV_START)
            {
                if (!this.mergeItemStack(itemstack1, INV_START, HOTBAR_END+1, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            // Item is in player inventory, try to place in inscriber
            else if (index > OUTPUT)
            {
                // if it is a charged rune, place in the first open input slot
                if (itemstack1.getItem()== ModItems.powerCristall)
                {
                    if (!this.mergeItemStack(itemstack1, INPUT[0], INPUT[0]+1, false))
                    {
                        return null;
                    }
                }
                // if it's a blank scroll, place in the scroll slot
                else if (forge.isSource(itemstack1))
                {
                    if (!this.mergeItemStack(itemstack1, FUEL, FUEL+1, false))
                    {
                        return null;
                    }
                }
                // item in player's inventory, but not in action bar
                else if (index >= INV_START && index < HOTBAR_START)
                {
                    // place in action bar
                    if (!this.mergeItemStack(itemstack1, HOTBAR_START, HOTBAR_END+1, false))
                    {
                        return null;
                    }
                }
                // item in action bar - place in player inventory
                else if (index >= HOTBAR_START && index < HOTBAR_END+1 && !this.mergeItemStack(itemstack1, INV_START, HOTBAR_START, false))
                {
                    return null;
                }
            }
            // In one of the inscriber slots; try to place in player inventory / action bar
            else if (!this.mergeItemStack(itemstack1, INV_START, HOTBAR_END+1, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
        }
        return itemstack;
    }
}
