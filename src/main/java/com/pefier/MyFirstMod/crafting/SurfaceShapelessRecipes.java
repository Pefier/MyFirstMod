package com.pefier.MyFirstMod.crafting;

import com.google.common.collect.Lists;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by New Profile on 11.04.2016.
 */
public class SurfaceShapelessRecipes implements IRecipe {
    private final ItemStack recipeOutput;
    public final List<ItemStack> recipeItems;

    public SurfaceShapelessRecipes(ItemStack recipeOutput, List<ItemStack> recipeItems) {
        this.recipeOutput = recipeOutput;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {
        List<ItemStack> list = Lists.newArrayList(this.recipeItems);

        for(int i = 0;i<inv.getHeight();i++){

            for (int j = 0;j< inv.getWidth();j++){

                ItemStack itemStack = inv.getStackInRowAndColumn(j,i);

                if(itemStack != null){
                    boolean flag = false;

                    for(ItemStack itemStack1 : list){
                        if(itemStack.getItem() == itemStack1.getItem()){
                            flag =true;
                            list.remove(itemStack1);
                            break;
                        }
                    }

                    if(!flag){
                        return false;
                    }

                }
            }

        }

        return  list.isEmpty();
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        //änderungen für nbt;
        NBtRingInit nBtRingInit = new NBtRingInit();
        return nBtRingInit.calcNBT(this.recipeItems,this.recipeOutput).copy();


    }

    @Override
    public int getRecipeSize() {
        return this.recipeItems.size();
    }

    @Override
    public ItemStack getRecipeOutput() {



        return this.recipeOutput;
    }

    @Override
    public ItemStack[] getRemainingItems(InventoryCrafting inv) {
        ItemStack[] aitemstack = new ItemStack[inv.getSizeInventory()];

        for (int i = 0; i < aitemstack.length; ++i)
        {
            ItemStack itemstack = inv.getStackInSlot(i);
            aitemstack[i] = net.minecraftforge.common.ForgeHooks.getContainerItem(itemstack);
        }

        return aitemstack;
    }
}
