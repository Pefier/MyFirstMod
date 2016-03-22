package com.pefier.MyFirstMod.item;

import com.pefier.MyFirstMod.init.ModItems;
import com.pefier.MyFirstMod.utility.NBTHelper;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.List;


/**
 * Created by Pefier on 10.03.2016.
 */
public class ItemRingFlash extends ItemMFM{

    private final String name ="RingFlash";
    private static final String TAG_FLASH = "tag_flash";
    private static final String TAG_STATUS ="tag_status";
    private static final String TAG_ARMORRESETVALUE ="tag_wert";


    public ItemRingFlash(){
        super();
        GameRegistry.registerItem( this , name);
        setUnlocalizedName(name);
        setHasSubtypes(true);
        setMaxStackSize(1);
    }
    public String getName(){
        return name;
    }



    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
        if (itemStackIn.getTagCompound()==null){
            NBTTagCompound data = new NBTTagCompound();
            data.setBoolean(TAG_STATUS, true);
            data.setInteger(TAG_ARMORRESETVALUE,0);
            itemStackIn.setTagInfo(TAG_FLASH,data);
        }


        if(NBTHelper.getNBTTagBoolean(itemStackIn,TAG_STATUS,TAG_FLASH)){

            playerIn.inventory.addItemStackToInventory(playerIn.getEquipmentInSlot(1));
            playerIn.inventory.addItemStackToInventory(playerIn.getEquipmentInSlot(2));
            playerIn.inventory.addItemStackToInventory(playerIn.getEquipmentInSlot(3));
            playerIn.inventory.addItemStackToInventory(playerIn.getEquipmentInSlot(4));

            playerIn.setCurrentItemOrArmor(1,new ItemStack(ModItems.flash_boots));
            playerIn.setCurrentItemOrArmor(2,new ItemStack(ModItems.flash_legs));
            playerIn.setCurrentItemOrArmor(3,new ItemStack(ModItems.flash_chest));
            playerIn.setCurrentItemOrArmor(4,new ItemStack(ModItems.flash_helm));

            itemStackIn.setItemDamage(1);
            //effects
            playerIn.addPotionEffect(new PotionEffect(Potion.regeneration.getId(),2000,2));


            playerIn.capabilities.setPlayerWalkSpeed(2);


            //to do making the player stop from acessing armor solts.


            NBTHelper.setNBTTagBoolean(itemStackIn,TAG_STATUS,TAG_FLASH,false);
        }else {
            NBTHelper.setNBTTagInt(itemStackIn, TAG_ARMORRESETVALUE,TAG_FLASH,NBTHelper.getNBTTagInt(itemStackIn, TAG_ARMORRESETVALUE,TAG_FLASH)+playerIn.inventory.clearMatchingItems(ModItems.flash_boots,-1,-1,null) );
            NBTHelper.setNBTTagInt(itemStackIn, TAG_ARMORRESETVALUE,TAG_FLASH,NBTHelper.getNBTTagInt(itemStackIn, TAG_ARMORRESETVALUE,TAG_FLASH)+playerIn.inventory.clearMatchingItems(ModItems.flash_legs,-1,-1,null) );
            NBTHelper.setNBTTagInt(itemStackIn, TAG_ARMORRESETVALUE,TAG_FLASH,NBTHelper.getNBTTagInt(itemStackIn, TAG_ARMORRESETVALUE,TAG_FLASH)+playerIn.inventory.clearMatchingItems(ModItems.flash_chest,-1,-1,null) );
            NBTHelper.setNBTTagInt(itemStackIn, TAG_ARMORRESETVALUE,TAG_FLASH,NBTHelper.getNBTTagInt(itemStackIn, TAG_ARMORRESETVALUE,TAG_FLASH)+playerIn.inventory.clearMatchingItems(ModItems.flash_helm,-1,-1,null) );

            if (4==NBTHelper.getNBTTagInt(itemStackIn, TAG_ARMORRESETVALUE,TAG_FLASH)) {
                //deactivation
                NBTHelper.setNBTTagBoolean(itemStackIn, TAG_STATUS, TAG_FLASH, true);
                NBTHelper.setNBTTagInt(itemStackIn, TAG_ARMORRESETVALUE, TAG_FLASH, 0);
                itemStackIn.setItemDamage(0);
                playerIn.clearActivePotions();
                playerIn.capabilities.setPlayerWalkSpeed(0.1F);

            }







        }
        return super.onItemRightClick(itemStackIn, worldIn, playerIn);
    }


    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "." + (stack.getItemDamage() == 0 ? "aktive" : "normal");
    }

    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List subItems) {
        subItems.add(new ItemStack(itemIn, 1, 0));
        subItems.add(new ItemStack(itemIn, 1, 1));
    }

}
