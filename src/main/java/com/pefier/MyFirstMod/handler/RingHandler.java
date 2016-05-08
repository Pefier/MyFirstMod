package com.pefier.MyFirstMod.handler;

import com.pefier.MyFirstMod.init.ModItems;
import com.pefier.MyFirstMod.item.ItemMFM;
import com.pefier.MyFirstMod.reference.Name;
import com.pefier.MyFirstMod.reference.Reference;
import com.pefier.MyFirstMod.utility.InventoryHelper;
import com.pefier.MyFirstMod.utility.NBTHelper;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.UUID;

/**
 * Created by New Profile on 13.04.2016.
 */
public class RingHandler {

    @SubscribeEvent
    public void breakSpeed(PlayerEvent.BreakSpeed event){
        if(!InventoryHelper.hasItem(event.getEntityPlayer(),ModItems.ringGreenLantern)){
            return;

        }

        if(InventoryHelper.getItemStackinInventory(event.getEntityPlayer(), ModItems.ringGreenLantern).getMetadata() !=1){
            return;
        }

        if(!InventoryHelper.getItemStackinInventory(event.getEntityPlayer(),ModItems.ringGreenLantern).hasTagCompound()){
            return;
        }
        if(NBTHelper.getNBTTagInt(InventoryHelper.getItemStackinInventory(event.getEntityPlayer(),ModItems.ringGreenLantern), Name.NBTKey.TAG_MININGSPEED,Name.NBTKey.TAG_RINGDATA)<=0){
            return;
        }
        if(event.getOriginalSpeed() >= NBTHelper.getNBTTagInt(InventoryHelper.getItemStackinInventory(event.getEntityPlayer(),ModItems.ringGreenLantern), Name.NBTKey.TAG_MININGSPEED,Name.NBTKey.TAG_RINGDATA)){
            return;
        }

        System.out.println("Old Seed: "+event.getOriginalSpeed());
        event.setNewSpeed((float) NBTHelper.getNBTTagInt(InventoryHelper.getItemStackinInventory(event.getEntityPlayer(),ModItems.ringGreenLantern), Name.NBTKey.TAG_MININGSPEED,Name.NBTKey.TAG_RINGDATA));
        System.out.println("New Speed"+event.getNewSpeed()+"Old Speed"+event.getOriginalSpeed());


    }

    @SubscribeEvent
    public void entityisAttack(LivingHurtEvent event){
        if(!(event.getEntityLiving() instanceof EntityPlayer)){
            return;
        }
        if(!InventoryHelper.hasItem((EntityPlayer) event.getEntityLiving(),ModItems.ringGreenLantern)){
            return;
        }
        if(InventoryHelper.getItemStackinInventory((EntityPlayer) event.getEntityLiving() , ModItems.ringGreenLantern).getMetadata() !=1){
            return;
        }

        if(!InventoryHelper.getItemStackinInventory((EntityPlayer) event.getEntityLiving() ,ModItems.ringGreenLantern).hasTagCompound()){
            return;
        }

        if(NBTHelper.getNBTTagInt(InventoryHelper.getItemStackinInventory((EntityPlayer)event.getEntityLiving() ,ModItems.ringGreenLantern), Name.NBTKey.TAG_DMGREDUKTION,Name.NBTKey.TAG_RINGDATA)<=0){
            return;
        }

        float dmgReduktion =(float)  NBTHelper.getNBTTagInt(InventoryHelper.getItemStackinInventory((EntityPlayer)event.getEntityLiving() ,ModItems.ringGreenLantern), Name.NBTKey.TAG_DMGREDUKTION,Name.NBTKey.TAG_RINGDATA)/100f;
        int charge = NBTHelper.getNBTTagInt(InventoryHelper.getItemStackinInventory((EntityPlayer)event.getEntityLiving() ,ModItems.ringGreenLantern), Name.NBTKey.TAG_CHARGE,Name.NBTKey.TAG_RINGDATA);
        System.out.println("damage bevor reduced " +event.getAmount());
        float x =(dmgReduktion * event.getAmount());
        charge = charge- (int)(event.getAmount()*2);
        event.setAmount(event.getAmount()-x);

        NBTHelper.setNBTTagInt(InventoryHelper.getItemStackinInventory((EntityPlayer)event.getEntityLiving() ,ModItems.ringGreenLantern), Name.NBTKey.TAG_CHARGE,Name.NBTKey.TAG_RINGDATA,charge);
        System.out.println("damage taken "+ event.getAmount());
    }




}
