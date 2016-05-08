package com.pefier.MyFirstMod.crafting;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.*;

import com.pefier.MyFirstMod.init.ModItems;
import com.pefier.MyFirstMod.reference.Name;
import com.pefier.MyFirstMod.utility.NBTHelper;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

/**
 * Created by New Profile on 03.04.2016.
 */
public class CraftingSurfaceCraftingManager {
    /** The static instance of this class */
    private static final CraftingSurfaceCraftingManager instance = new CraftingSurfaceCraftingManager();

    private final List<IRecipe> recipes = Lists.<IRecipe>newArrayList();

    /**
     * Returns the static instance of this class
     */
    public static CraftingSurfaceCraftingManager getInstance()
    {
        /** The static instance of this class */
        return instance;
    }

    private CraftingSurfaceCraftingManager()
    {
        this.addShapelessRecipe(new ItemStack(ModItems.ringGreenLantern),new Object[]{new ItemStack(ModItems.powerCristallUnlocked), new ItemStack(ModItems.powerCristallUnlocked)});
        this.addShapelessRecipe(new ItemStack(ModItems.ringGreenLantern),new Object[]{new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked)});
        this.addShapelessRecipe(new ItemStack(ModItems.ringGreenLantern),new Object[]{new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked)});
        this.addShapelessRecipe(new ItemStack(ModItems.ringGreenLantern),new Object[]{new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked)});
        this.addShapelessRecipe(new ItemStack(ModItems.ringGreenLantern),new Object[]{new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked)});
        this.addShapelessRecipe(new ItemStack(ModItems.ringGreenLantern),new Object[]{new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked)});
        this.addShapelessRecipe(new ItemStack(ModItems.ringGreenLantern),new Object[]{new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked)});
        this.addShapelessRecipe(new ItemStack(ModItems.ringGreenLantern),new Object[]{new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked)});
        this.addShapelessRecipe(new ItemStack(ModItems.ringGreenLantern),new Object[]{new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked),new ItemStack(ModItems.powerCristallUnlocked)});


    }





    public void addShapelessRecipe(ItemStack stack, Object... recipeComponents)
    {
        List<ItemStack> list = Lists.<ItemStack>newArrayList();

        for (Object object : recipeComponents)
        {
            if (object instanceof ItemStack)
            {
                list.add(((ItemStack)object).copy());
            }
            else if (object instanceof Item)
            {
                list.add(new ItemStack((Item)object));
            }
            else
            {
                if (!(object instanceof Block))
                {
                    throw new IllegalArgumentException("Invalid shapeless recipe: unknown type " + object.getClass().getName() + "!");
                }

                list.add(new ItemStack((Block)object));
            }
        }




        this.recipes.add(new SurfaceShapelessRecipes(stack, list));
    }


    public void addRecipe(IRecipe recipe)
    {
        this.recipes.add(recipe);
    }


    public ItemStack findMatchingRecipe(InventoryCrafting inventoryCrafting, World worldIn)
    {
        for (IRecipe irecipe : this.recipes)
        {
            if (irecipe.matches(inventoryCrafting, worldIn))
            {
                return irecipe.getCraftingResult(inventoryCrafting);
            }
        }

        return null;
    }

    public ItemStack[] func_180303_b(InventoryCrafting inventoryCrafting, World worldIn)
    {
        for (IRecipe irecipe : this.recipes)
        {
            if (irecipe.matches(inventoryCrafting, worldIn))
            {
                return irecipe.getRemainingItems(inventoryCrafting);
            }
        }

        ItemStack[] aitemstack = new ItemStack[inventoryCrafting.getSizeInventory()];

        for (int i = 0; i < aitemstack.length; ++i)
        {
            aitemstack[i] = inventoryCrafting.getStackInSlot(i);
        }

        return aitemstack;
    }



    public List<IRecipe> getRecipeList()
    {
        return this.recipes;
    }

}
