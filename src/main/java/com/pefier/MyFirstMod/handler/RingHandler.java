package com.pefier.MyFirstMod.handler;

import com.pefier.MyFirstMod.init.ModItems;
import com.pefier.MyFirstMod.reference.Name;
import com.pefier.MyFirstMod.utility.InventoryHelper;
import com.pefier.MyFirstMod.utility.NBTHelper;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by New Profile on 13.04.2016.
 */
public class RingHandler {

    @SubscribeEvent
    public void breakSpeed(PlayerEvent.BreakSpeed event){
        if(!event.entityPlayer.inventory.hasItem(ModItems.ringGreenLantern)){
            return;
        }

        if(InventoryHelper.getItemStackinInventory(event.entityPlayer, ModItems.ringGreenLantern).getMetadata() !=1){
            return;
        }

        if(!InventoryHelper.getItemStackinInventory(event.entityPlayer,ModItems.ringGreenLantern).hasTagCompound()){
            return;
        }
        if(NBTHelper.getNBTTagInt(InventoryHelper.getItemStackinInventory(event.entityPlayer,ModItems.ringGreenLantern), Name.NBTKey.TAG_MININGSPEED,Name.NBTKey.TAG_RINGDATA)<=0){
            return;
        }if(event.originalSpeed <= NBTHelper.getNBTTagInt(InventoryHelper.getItemStackinInventory(event.entityPlayer,ModItems.ringGreenLantern), Name.NBTKey.TAG_MININGSPEED,Name.NBTKey.TAG_RINGDATA)){
            return;
        }

        System.out.println("Old Seed: "+event.originalSpeed);
        event.newSpeed = 12F;
        System.out.println("New Speed"+event.newSpeed+"Old Speed"+event.originalSpeed);


    }
}
