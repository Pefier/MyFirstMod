package com.pefier.MyFirstMod.handler;

import com.pefier.MyFirstMod.MyFirstMod;
import com.pefier.MyFirstMod.client.settings.Keybindings;
import com.pefier.MyFirstMod.init.ModItems;
import com.pefier.MyFirstMod.packets.NoClipMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by New Profile on 17.03.2016.
 */
public class FlashHandler {

    /**ClimbWalls is aktive wenn aktivated rind is selected */

    @SubscribeEvent
    public void PhaseThroughWalls(LivingEvent.LivingUpdateEvent event){
        if(!(event.getEntityLiving() instanceof EntityPlayer)){
            return;

        }
        if(!(event.getEntityLiving().isCollidedHorizontally)){
            return;
        }

        if (!(((EntityPlayer) event.getEntityLiving()).inventory.hasItemStack(new ItemStack(ModItems.ringFlash)))){
            return;
        }
        if((((EntityPlayer) event.getEntityLiving()).inventory.getCurrentItem()== null)){

            return;
        }
        if ((((EntityPlayer) event.getEntityLiving()).inventory.getCurrentItem()!= null)&& !(((EntityPlayer) event.getEntityLiving()).inventory.getCurrentItem().getMetadata()== 1 )) {
            return;
        }
        if(!Keybindings.aktivate.isKeyDown()){

            return;
        }


        MyFirstMod.network.sendToServer(new NoClipMessage(true));
        ((EntityPlayer) event.getEntityLiving()).capabilities.allowFlying =true;
        ((EntityPlayer) event.getEntityLiving()).capabilities.isFlying =true;
        event.getEntityLiving().noClip = true;
        event.getEntityLiving().motionY=0;

    }
    @SubscribeEvent
    public void ClimbWalls(LivingEvent.LivingUpdateEvent event){
        Minecraft mc = Minecraft.getMinecraft();
        if(!(event.getEntityLiving() instanceof EntityPlayer)){
            return;
        }
        if(!(event.getEntityLiving().isCollidedHorizontally)){
            return;
        }

        if (!(((EntityPlayer) event.getEntityLiving()).inventory.hasItemStack(new ItemStack(ModItems.ringFlash)))){
            return;
        }
        if((((EntityPlayer) event.getEntityLiving()).inventory.getCurrentItem()== null)){

            return;
        }
        if ((((EntityPlayer) event.getEntityLiving()).inventory.getCurrentItem()!= null)&& !(((EntityPlayer) event.getEntityLiving()).inventory.getCurrentItem().getMetadata()== 1 )) {
            return;
        }
        if(!mc.gameSettings.keyBindJump.isKeyDown()){

            return;
        }
        event.getEntityLiving().motionY =0.5;

    }

}
