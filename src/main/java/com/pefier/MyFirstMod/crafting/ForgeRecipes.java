package com.pefier.MyFirstMod.crafting;

import com.google.common.collect.Table;
import com.pefier.MyFirstMod.container.ContainerCirstallForge;
import com.pefier.MyFirstMod.init.ModItems;
import javafx.util.Pair;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;
import java.util.*;




/**
 * Created by New Profile on 08.04.2016.
 */
public class ForgeRecipes {


    private static final ForgeRecipes forgeRecipes = new ForgeRecipes();
    //Implemetnt recipe handler

    private HashMap<Pair<ItemStack,ItemStack>,ItemStack> metaForgeTable=new HashMap<Pair<ItemStack, ItemStack>, ItemStack>();

    private HashMap<ItemStack, ItemStack> metaForgeList = new HashMap<ItemStack, ItemStack>();


    public static final ForgeRecipes recipes() {
        return forgeRecipes;
    }

    private ForgeRecipes() {
        //addRecipiesHERE

        this.addForgeRecipe(new ItemStack(ModItems.powerCristall,1,0),new ItemStack(Items.diamond),new ItemStack(ModItems.powerCristallUnlocked,1,0));
        this.addForgeRecipe(new ItemStack(ModItems.powerCristall,1,1),new ItemStack(Items.diamond),new ItemStack(ModItems.powerCristallUnlocked,1,1));
        this.addForgeRecipe(new ItemStack(ModItems.powerCristall,1,2),new ItemStack(Items.diamond),new ItemStack(ModItems.powerCristallUnlocked,1,2));
        this.addForgeRecipe(new ItemStack(ModItems.powerCristall,1,3),new ItemStack(Items.diamond),new ItemStack(ModItems.powerCristallUnlocked,1,3));

    }

    public void addForgeRecipe2(ItemStack input1, ItemStack input2, ItemStack stack) {
        // Check if recipe already exists and print conflict information:


        if (metaForgeList.containsKey(input1)) {
            System.out.println("[WARNING] Conflicting recipe: ");
        } else {

            metaForgeList.put(input1, stack);

        }
    }

    public void addForgeRecipe(ItemStack in1,ItemStack in2,ItemStack out){


        metaForgeTable.put(new Pair<ItemStack, ItemStack>(in1,in2),out);
    }

    public ItemStack getForgingResult2(ItemStack input1, ItemStack input2) {

        Iterator iterator = metaForgeList.entrySet().iterator();
        Map.Entry entry;
        do{
            if(!iterator.hasNext()){
                return  null;
            }
            entry =(Map.Entry)iterator.next();
        }while(!areItemStacksEqual(input1, (ItemStack)entry.getKey()));



        return(ItemStack)entry.getValue();
    }

    public ItemStack getForgingResult(ItemStack in1,ItemStack in2){
        Iterator iterator = metaForgeTable.entrySet().iterator();
        Map.Entry entry;
        do{
            if(!iterator.hasNext()){
                return  null;
            }
            entry =(Map.Entry)iterator.next();
        }while(!areItemPairStacksEqual(new Pair<ItemStack,ItemStack>(in1,in2) , (Pair<ItemStack,ItemStack>)entry.getKey()));



        return(ItemStack)entry.getValue();

    }



    private boolean areItemStacksEqual(ItemStack input1, ItemStack input2) {
       return input1.getItem() == input2.getItem() &&(input2.getMetadata() == 32767 || input1.getMetadata() == input2.getMetadata());
    }
    private boolean areItemPairStacksEqual(Pair<ItemStack,ItemStack> input1,Pair<ItemStack,ItemStack> input2){
        boolean flag =false;
        if(input1.getKey().getItem() == input2.getKey().getItem() && input1.getValue().getItem() == input2.getValue().getItem()){
            if((input2.getKey().getMetadata() == 32767 || input1.getKey().getMetadata() == input2.getKey().getMetadata()) && (input2.getValue().getMetadata() == 32767 || input1.getValue().getMetadata() == input2.getValue().getMetadata())){
                flag = true;
            }

        }


        return flag;
    }


    public Map<ItemStack, ItemStack> getMetaInscribingList() {
        return metaForgeList;
    }
}