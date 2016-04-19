package com.pefier.MyFirstMod.entity.tileEntity;


import com.pefier.MyFirstMod.container.ContainerCirstallForge;
import com.pefier.MyFirstMod.crafting.ForgeRecipes;
import com.pefier.MyFirstMod.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.EnumFacing;

import net.minecraft.util.ITickable;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;


/**
 * Created by New Profile on 07.04.2016.
 */
public class TileCristallForge extends TileEntity implements ISidedInventory, ITickable{



    private static final int[] slotsTop = new int[] {0};
    private static final int[] slotsBottom = new int[] {2};
    private static final int[] slotsSides = new int[] {1};
    //0 1 input 2 fuel 3 output
    private ItemStack[] forgeItemStackArray = new ItemStack[4];

    //Time is in ticks

    //time required for forging an item. ==
    private int totalForgeTime=200;
    //The number of ticks that the forge will keep forging ==FurnaceBurntime
    private int forgeBurnTime=0;
    //the number of ticks a pice of coal will provide
    private int forgeTime=0;

    private int currentItemForgeBurnTime;


    private String CristallForgeCustomName;

    public TileCristallForge(){
        super();


    }

    @Override
    public int getSizeInventory() {
        return forgeItemStackArray.length;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return forgeItemStackArray[index];
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {

        ItemStack stack = getStackInSlot (index);

        if (stack != null) {
            if (stack.stackSize <= count) {
                setInventorySlotContents(index, null);
            } else {
                stack = stack.splitStack(count);
                if (stack.stackSize == 0) {
                    setInventorySlotContents(index, null);
                }

            }
        }
        return stack;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        forgeItemStackArray[index] = stack;
        boolean flag = stack != null && stack.isItemEqual(this.forgeItemStackArray[index]);
        if(stack != null && stack.stackSize > getInventoryStackLimit()){
            stack.stackSize = getInventoryStackLimit();
        }
        if(index == 2 && !flag){
            this.totalForgeTime = this.getCookTime(stack);
            this.forgeTime = 0;
            this.markDirty();

        }
    }

    @Override
    public String getName() {
        return hasCustomName() ? CristallForgeCustomName : "container.CristallForge";
    }

    @Override
    public boolean hasCustomName() {
        return CristallForgeCustomName != null && CristallForgeCustomName.length() > 0;
    }

    @Override
    public ITextComponent getDisplayName() {
        return null;
    }


    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    public boolean isForging(){
        return this.forgeBurnTime >0;
    }

    @Override
    public void update() {
        boolean flag = this.isForging();
        boolean flag1 = false;


            if(this.isForging()) {
                --this.forgeBurnTime;
            }

            if(!worldObj.isRemote){
                if(this.isForging()|| this.forgeItemStackArray[0] != null && this.forgeItemStackArray[1] != null && this.forgeItemStackArray[2]!=null ){

                    if (!this.isForging() && this.canForge()) {
                        this.forgeBurnTime = this.getForgeBurnTime(this.forgeItemStackArray[2]);

                        if(this.isForging()){

                            flag1 = true;
                            if(this.forgeItemStackArray[2] != null){
                                --this.forgeItemStackArray[2].stackSize;
                                if(this.forgeItemStackArray[2].stackSize ==0){
                                    this.forgeItemStackArray[2] = forgeItemStackArray[2].getItem().getContainerItem(forgeItemStackArray[2]);
                                }
                            }
                        }

                    }
                    if (this.isForging() && this.canForge()){

                        ++this.forgeTime;
                        if(this.forgeTime == totalForgeTime){
                            this.forgeTime=0;
                            this.totalForgeTime = this.getCookTime(this.forgeItemStackArray[0]);
                            this.forge();
                            flag1 = true;

                        }

                    }else{
                        this.forgeTime= 0;
                    }

                }else if(!this.isForging() && this.forgeTime >0){
                    this.forgeTime = MathHelper.clamp_int(this.forgeTime-2,0,this.totalForgeTime);
                }
                if(flag != this.isForging()){
                    flag1 = true;

                }
            }

        if (flag1)
        {
            this.markDirty();
        }

    }
    public int getCookTime(ItemStack stack){

        return 200;

    }

    public ItemStack getCurrentRecipe() {

        return ForgeRecipes.recipes().getForgingResult(this.forgeItemStackArray[0],this.forgeItemStackArray[1]);

    }

    private boolean canForge() {
        if (forgeItemStackArray[0] == null || forgeItemStackArray[1] == null) {
            return false;

        } else {

            ItemStack itemstack = ForgeRecipes.recipes().getForgingResult(this.forgeItemStackArray[0],this.forgeItemStackArray[1]);

            if (itemstack == null) return false;
            if (this.forgeItemStackArray[3] == null) return true;
            if (!this.forgeItemStackArray[3].isItemEqual(itemstack)) return false;
            int result = forgeItemStackArray[3].stackSize + itemstack.stackSize;
            return result <= getInventoryStackLimit() && result <= this.forgeItemStackArray[3].getMaxStackSize();


        }

    }
    public void forge(){
        if(this.canForge()){

            ItemStack stackResult = ForgeRecipes.recipes().getForgingResult(this.forgeItemStackArray[0],this.forgeItemStackArray[1]);

            if(stackResult !=null){
                if(this.forgeItemStackArray[3]==null){
                    this.forgeItemStackArray[3] = stackResult.copy();

                }else if(this.forgeItemStackArray[3].isItemEqual(stackResult)){
                    this.forgeItemStackArray[3].stackSize += stackResult.stackSize;
                }
                --this.forgeItemStackArray[0].stackSize;
                if(this.forgeItemStackArray[0].stackSize <= 0){
                    this.forgeItemStackArray[0] = null;
                }
                --this.forgeItemStackArray[1].stackSize;
                if(this.forgeItemStackArray[1].stackSize <= 0){
                    this.forgeItemStackArray[1] = null;
                }
            }

        }

    }

    public static int getForgeBurnTime(ItemStack stack)
    {
        return TileEntityFurnace.getItemBurnTime(stack);

    }
    public static boolean isSource(ItemStack itemstack)
    {
        return getForgeBurnTime(itemstack) > 0;
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        if(forgeItemStackArray[index] != null){
            ItemStack itemStack = forgeItemStackArray[index];
            forgeItemStackArray[index]= null;
            return itemStack;
        }else {
            return null;
        }
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {

        if(worldObj.getTileEntity(pos) != this){
            return false;
        }else{
            return player.getDistance((double) pos.getX()+0.5D, pos.getY()+0.5D, pos.getZ()+0.5D) <= 64.0D;
        }
    }

    @Override
    public int getField(int id) {
        switch (id){
            case 0: return forgeBurnTime;
            case 1: return currentItemForgeBurnTime;
            case 2: return forgeTime;
            case 3: return totalForgeTime;
            default: return 0;
        }

    }

    @Override
    public void setField(int id, int value) {
        switch (id){
            case 0:
                forgeBurnTime = value;
                break;
            case 1:
                currentItemForgeBurnTime = value;
                break;
            case 2:
                forgeTime = value;
                break;
            case 3:
                totalForgeTime = value;
                break;
            default:
                break;
        }
    }

    @Override
    public int getFieldCount() {
        return 4;
    }

    @Override
    public void clear() {
        for (int i=0; i< forgeItemStackArray.length; i++){
            forgeItemStackArray[i]= null;
        }

    }

    @Override
    public void openInventory(EntityPlayer player) {}

    @Override
    public void closeInventory(EntityPlayer player) {}

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {

        if(index == ContainerCirstallForge.INPUT[0]){
            return stack.getItem() == ModItems.powerCristall;
        }else if(index == ContainerCirstallForge.INPUT[1]){
            return true;
        }else{
            return false;
        }

    }
    @Override
    public int[] getSlotsForFace(EnumFacing side) {
        return side == EnumFacing.DOWN ? slotsBottom : (side == EnumFacing.UP ? slotsTop : slotsSides);
    }

    @Override
    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
        return isItemValidForSlot(index, itemStackIn);
    }

    @Override
    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
        return index == ContainerCirstallForge.OUTPUT;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
        NBTTagList nbttaglist = compound.getTagList("Items",10);
        forgeItemStackArray = new ItemStack[this.getSizeInventory()];

        for (int i = 0 ; i< nbttaglist.tagCount(); ++i){
            NBTTagCompound nbtTagCompound = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbtTagCompound.getByte("Slot");
            if (b0 >= 0 && b0 < forgeItemStackArray.length) {
                forgeItemStackArray[b0] = ItemStack.loadItemStackFromNBT(nbtTagCompound);
            }

        }
        this.forgeBurnTime = compound.getInteger("CurrentForgeTime");
        this.currentItemForgeBurnTime = compound.getInteger("CookTime");
        this.totalForgeTime = compound.getInteger("TotalCookTime");
    }

    @Override
    public void writeToNBT(NBTTagCompound compound){
        super.writeToNBT(compound);
        compound.setInteger("CurrentForgeTime", forgeBurnTime);
        compound.setInteger("CookTime", currentItemForgeBurnTime);
        compound.setInteger("TotalCookTime", totalForgeTime);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < forgeItemStackArray.length; ++i)
        {
            if (forgeItemStackArray[i] != null)
            {
                NBTTagCompound nbtTagCompound = new NBTTagCompound();
                nbtTagCompound.setByte("Slot", (byte)i);
                forgeItemStackArray[i].writeToNBT(nbtTagCompound);
                nbttaglist.appendTag(nbtTagCompound);
            }
        }

        compound.setTag("Items", nbttaglist);

        if (hasCustomName())
        {
            compound.setString("CustomName", CristallForgeCustomName);
        }

    }







}
