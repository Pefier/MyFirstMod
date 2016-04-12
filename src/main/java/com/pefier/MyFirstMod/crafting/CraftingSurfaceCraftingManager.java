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
        this.addShapelessRecipe(new ItemStack(ModItems.ringCold),new Object[]{new ItemStack(ModItems.powerCristallUnlocked), new ItemStack(ModItems.powerCristallUnlocked)});


        Collections.sort(this.recipes, new CraftingSurfaceRecepiSorter(this));
    }


    public CraftingSurfaceShapedRecipes addRecipe(ItemStack stack, Object... recipeComponents)
    {
        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;

        if (recipeComponents[i] instanceof String[])
        {
            String[] astring = (String[])((String[])recipeComponents[i++]);

            for (int l = 0; l < astring.length; ++l)
            {
                String s2 = astring[l];
                ++k;
                j = s2.length();
                s = s + s2;

            }
        }
        else
        {
            while (recipeComponents[i] instanceof String)
            {
                String s1 = (String)recipeComponents[i++];
                ++k;
                j = s1.length();
                s = s + s1;
            }
        }

        Map<Character, ItemStack> map;

        for (map = Maps.<Character, ItemStack>newHashMap(); i < recipeComponents.length; i += 2)
        {
            Character character = (Character)recipeComponents[i];
            ItemStack itemstack = null;

            if (recipeComponents[i + 1] instanceof Item)
            {
                itemstack = new ItemStack((Item)recipeComponents[i + 1]);
            }
            else if (recipeComponents[i + 1] instanceof Block)
            {
                itemstack = new ItemStack((Block)recipeComponents[i + 1], 1, 32767);
            }
            else if (recipeComponents[i + 1] instanceof ItemStack)
            {
                itemstack = (ItemStack)recipeComponents[i + 1];
            }

            map.put(character, itemstack);
        }

        ItemStack[] aitemstack = new ItemStack[j * k];

        for (int i1 = 0; i1 < j * k; ++i1)
        {
            char c0 = s.charAt(i1);

            if (map.containsKey(Character.valueOf(c0)))
            {
                aitemstack[i1] = ((ItemStack)map.get(Character.valueOf(c0))).copy();
            }
            else
            {
                aitemstack[i1] = null;
            }
        }

        CraftingSurfaceShapedRecipes shapedrecipes = new CraftingSurfaceShapedRecipes(j, k, aitemstack, stack);
        this.recipes.add(shapedrecipes);
        return shapedrecipes;
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
