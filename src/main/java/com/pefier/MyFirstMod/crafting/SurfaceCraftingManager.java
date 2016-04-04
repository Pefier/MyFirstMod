package com.pefier.MyFirstMod.crafting;

import com.google.common.collect.Lists;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

import java.util.Collections;
import java.util.List;

/**
 * Created by New Profile on 04.04.2016.
 */
public class SurfaceCraftingManager  {
    private static final SurfaceCraftingManager instance = new SurfaceCraftingManager();
    private final List<IRecipe> recipes = Lists.<IRecipe>newArrayList();
    private final CraftingManager craftingManager;
    private SurfaceCraftingManager() {
        craftingManager = CraftingManager.getInstance();

    }

    public static SurfaceCraftingManager getInstance(){
        return instance;
    }



}
