package com.pefier.MyFirstMod.container;


import com.pefier.MyFirstMod.crafting.CraftingSurfaceCraftingManager;
import com.pefier.MyFirstMod.init.ModBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

/**
 * Created by New Profile on 03.04.2016.
 */
public class ContainerCraftingSurface extends Container {

    public InventoryCrafting craftMatrix;
    public IInventory craftResult;
    private World worldObj;
    private int xPos;
    private int yPos;
    private int zPos;

    public static final int OUTPUT =16; //Input_1 ...Input_16 = 0...15


    public ContainerCraftingSurface(InventoryPlayer playerInv, World world, int x,int y, int z){

        this.craftMatrix = new InventoryCrafting(this,4,4);
        this.craftResult = new InventoryCraftResult();
        this.worldObj=world;
        this.xPos =x;
        this.yPos =y;
        this.zPos=z;



        int index=0;
        int i ;
        int j ;
        int k;

        //CraftingInventory


        for(j =0; j< 4;j++){
            for(k =0;k<4;k++) {
                this.addSlotToContainer(new Slot(craftMatrix, index++, 14+k*18,6+j*18));

            }
        }

        this.addSlotToContainer(new SlotCrystallCrafting(playerInv.player,craftMatrix,craftResult,index++,124,36));


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



        onCraftMatrixChanged(craftMatrix);

    }

    @Override
    public void onCraftMatrixChanged(IInventory inventoryIn) {
        craftResult.setInventorySlotContents(0, CraftingSurfaceCraftingManager.getInstance().findMatchingRecipe(craftMatrix,worldObj));
    }


    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        if (worldObj.getBlockState(new BlockPos(xPos,yPos,zPos)).getBlock()!= ModBlocks.craftingSurface){
            return false;
        }else{
            return playerIn.getDistance((double) xPos +0.5D,(double) yPos +0.5D,(double) zPos +0.5D) <= 64.0D;
        }

    }


    @Override
    public void onContainerClosed(EntityPlayer playerIn) {
        super.onContainerClosed(playerIn);

        if (!this.worldObj.isRemote)
        {
            for (int i = 0; i < 16; ++i)
            {
                ItemStack itemstack = this.craftMatrix.removeStackFromSlot(i);

                if (itemstack != null)
                {
                    playerIn.dropPlayerItemWithRandomChoice(itemstack, false);
                }
            }
        }
    }



    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        ItemStack itemstack = null;
        Slot slot =(Slot) this.inventorySlots.get(index);

        if(slot != null && slot.getHasStack()){

            ItemStack itemstack1 =slot.getStack();
            itemstack = itemstack1.copy();

            if(index == OUTPUT){
                if(!this.mergeItemStack(itemstack1,OUTPUT+1,OUTPUT+36+1,true)){
                    return null;
                }
                slot.onSlotChange(itemstack1,itemstack);
            }else if(index != 0 && index != 1 && index != 2 && index != 3 && index != 4 && index != 5 && index != 6 && index != 7 && index != 8 && index != 9 && index != 10 && index != 11 && index != 12 && index != 13 && index != 14 && index != 15 ){
                if (index >= OUTPUT+1 && index < OUTPUT+28){
                    if (!this.mergeItemStack(itemstack1, OUTPUT+28, OUTPUT+37, false)) {
                        return null;
                    }
                }
                else if (index >= OUTPUT+28 && index < OUTPUT+37 && !this.mergeItemStack(itemstack1, OUTPUT+1, OUTPUT+28, false)) {
                    return null;
                }
            }else if(!this.mergeItemStack(itemstack1,OUTPUT+1,OUTPUT+37,false)){
                return null;
            }
            if(itemstack1.stackSize ==0){
                slot.putStack((ItemStack) null);
            }else{
                slot.onSlotChanged();
            }
            if(itemstack1.stackSize == itemstack.stackSize){
                return null;
            }
            slot.onPickupFromSlot(playerIn,itemstack1);
        }
        return itemstack;
    }
    public boolean canMergeSlot(ItemStack stack, Slot slot) {

        return slot.inventory != this.craftResult && super.canMergeSlot(stack, slot);
    }

}
