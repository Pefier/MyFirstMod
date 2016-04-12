package com.pefier.MyFirstMod.crafting;

import net.minecraft.item.crafting.IRecipe;

import java.util.Comparator;

/**
 * Created by New Profile on 03.04.2016.
 */
public class CraftingSurfaceRecepiSorter implements Comparator{

    private final CraftingSurfaceCraftingManager craftingSurface;

    public CraftingSurfaceRecepiSorter(CraftingSurfaceCraftingManager craftingSurfaceCraftingManager) {

        this.craftingSurface = craftingSurfaceCraftingManager;
    }

    public int compareRecepies(IRecipe irecipe1, IRecipe irecipe2){
        return irecipe1 instanceof SurfaceShapelessRecipes && irecipe2 instanceof CraftingSurfaceShapedRecipes ? 1:(irecipe2 instanceof SurfaceShapelessRecipes && irecipe1 instanceof CraftingSurfaceShapedRecipes ? -1 :(irecipe2.getRecipeSize() < irecipe1.getRecipeSize() ? -1 : (irecipe2.getRecipeSize() > irecipe1.getRecipeSize() ? 1 : 0)));
    }

    @Override
    public int compare(Object o1, Object o2) {
        return this.compareRecepies((IRecipe)o1,(IRecipe)o2);
    }
}
