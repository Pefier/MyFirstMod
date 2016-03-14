package com.pefier.MyFirstMod.item;

import com.pefier.MyFirstMod.init.ModItems;
import com.pefier.MyFirstMod.utility.NBTHelper;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;



/**
 * Created by Pefier on 10.03.2016.
 */
public class ItemRingFlash extends ItemMFM {

    private final String name ="RingFlash";
    private static final String TAG_FLASH = "tag_flash";
    private static final String TAG_STATUS ="tag_status";


    public ItemRingFlash(){

        GameRegistry.registerItem( this , name);
        setUnlocalizedName(name);

    }
    public String getName(){
        return name;
    }



    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
        if (itemStackIn.getTagCompound()==null){
            NBTTagCompound data = new NBTTagCompound();
            data.setBoolean(TAG_STATUS, true);
            itemStackIn.setTagInfo(TAG_FLASH,data);
            System.out.println("Initializing tag");
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
            //to do making the player stop from acessing armor solts.



            Double a = playerIn.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getBaseValue();
            System.out.println("if Aktuell MovementSpeed" + a);
            NBTHelper.setNBTTagBoolean(itemStackIn,TAG_STATUS,TAG_FLASH,false);
        }else {
            int x = playerIn.inventory.clearMatchingItems(ModItems.flash_boots,-1,-1,null);
            x += playerIn.inventory.clearMatchingItems(ModItems.flash_legs,-1,-1,null);
            x += playerIn.inventory.clearMatchingItems(ModItems.flash_chest,-1,-1,null);
            x += playerIn.inventory.clearMatchingItems(ModItems.flash_helm,-1,-1,null);
            if (x==4)
                NBTHelper.setNBTTagBoolean(itemStackIn, TAG_STATUS, TAG_FLASH, true);

            Double a = playerIn.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getBaseValue();
            System.out.println("else Aktuell MovementSpeed" + a);


        }
        return super.onItemRightClick(itemStackIn, worldIn, playerIn);
    }

    private void clearArmorSlots(EntityPlayer playerIn,ItemStack itemStackIn){
        if (playerIn.getCurrentArmor(0) != null && playerIn.getCurrentArmor(1) != null && playerIn.getCurrentArmor(2) != null && playerIn.getCurrentArmor(3) != null){
            if (playerIn.getCurrentArmor(0).getItem() == ModItems.flash_boots
                    && playerIn.getCurrentArmor(2).getItem() == ModItems.flash_chest
                    && playerIn.getCurrentArmor(3).getItem() == ModItems.flash_helm
                    && playerIn.getCurrentArmor(1).getItem() == ModItems.flash_legs) {

                playerIn.setCurrentItemOrArmor(1, null);
                playerIn.setCurrentItemOrArmor(2, null);
                playerIn.setCurrentItemOrArmor(3, null);
                playerIn.setCurrentItemOrArmor(4, null);
                NBTHelper.setNBTTagBoolean(itemStackIn, TAG_STATUS, TAG_FLASH, true);
            }
        }

    }
}
