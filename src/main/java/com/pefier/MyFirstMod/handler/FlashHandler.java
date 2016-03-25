package com.pefier.MyFirstMod.handler;

import com.pefier.MyFirstMod.MyFirstMod;
import com.pefier.MyFirstMod.client.settings.Keybindings;
import com.pefier.MyFirstMod.init.ModItems;
import com.pefier.MyFirstMod.packets.NoClipMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by New Profile on 17.03.2016.
 */
public class FlashHandler {

    /**ClimbWalls is aktive wenn aktivated rind is selected */

    @SubscribeEvent
    public void PhaseThroughWalls(LivingEvent.LivingUpdateEvent event){
        if(!(event.entity instanceof EntityPlayer)){
            return;
        }
        if(!(event.entity.isCollidedHorizontally)){
            return;
        }

        if (!(((EntityPlayer) event.entity).inventory.hasItem(ModItems.ringFlash))){
            return;
        }
        if((((EntityPlayer) event.entity).inventory.getCurrentItem()== null)){

            return;
        }
        if ((((EntityPlayer) event.entity).inventory.getCurrentItem()!= null)&& !(((EntityPlayer) event.entity).inventory.getCurrentItem().getMetadata()== 1 )) {
            return;
        }
        if(!Keybindings.aktivate.isKeyDown()){

            return;
        }


        MyFirstMod.network.sendToServer(new NoClipMessage(true));
        ((EntityPlayer) event.entity).capabilities.allowFlying =true;
        ((EntityPlayer) event.entity).capabilities.isFlying =true;
        event.entity.noClip = true;
        event.entity.motionY=0;

    }
    @SubscribeEvent
    public void ClimbWalls(LivingEvent.LivingUpdateEvent event){
        Minecraft mc = Minecraft.getMinecraft();
        if(!(event.entity instanceof EntityPlayer)){
            return;
        }
        if(!(event.entity.isCollidedHorizontally)){
            return;
        }

        if (!(((EntityPlayer) event.entity).inventory.hasItem(ModItems.ringFlash))){
            return;
        }
        if((((EntityPlayer) event.entity).inventory.getCurrentItem()== null)){

            return;
        }
        if ((((EntityPlayer) event.entity).inventory.getCurrentItem()!= null)&& !(((EntityPlayer) event.entity).inventory.getCurrentItem().getMetadata()== 1 )) {
            return;
        }
        if(!mc.gameSettings.keyBindJump.isKeyDown()){

            return;
        }
        event.entity.motionY =0.5;

    }

}
