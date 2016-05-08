package com.pefier.MyFirstMod.crafting;

import com.pefier.MyFirstMod.entity.tileEntity.TileCristallForge;
import com.pefier.MyFirstMod.init.ModBlocks;
import com.pefier.MyFirstMod.init.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by New Profile on 08.05.2016.
 */
public class VanillaRecepies {

    public static void init(){
        GameRegistry.addRecipe( new ItemStack(ModBlocks.cristallForge) ,"ggg","cfc","ooo",'o', Blocks.obsidian,'g',Blocks.glass,'c', new ItemStack(ModItems.powerCristall,1, OreDictionary.WILDCARD_VALUE), 'f',Blocks.furnace);
        GameRegistry.addRecipe(new ItemStack(ModBlocks.charger),"o o","oco","ooo", 'o',Blocks.obsidian,'c',new ItemStack(ModItems.powerCristallUnlocked,1, OreDictionary.WILDCARD_VALUE));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.craftingSurface),"oco","ctc","oco",'o',Blocks.obsidian,'c',new ItemStack(ModItems.powerCristallUnlocked,1, OreDictionary.WILDCARD_VALUE),'t',Blocks.crafting_table);

    }
}
