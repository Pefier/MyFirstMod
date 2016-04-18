package com.pefier.MyFirstMod.client.handler;

import com.pefier.MyFirstMod.client.settings.Keybindings;
import com.pefier.MyFirstMod.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

/**
 * Created by New Profile on 18.03.2016.
 */
public class KeyHandler {
    @SubscribeEvent
    public void keyInput(InputEvent.KeyInputEvent event){
        Minecraft mc = Minecraft.getMinecraft();
        ItemStack stack = mc.thePlayer.getHeldItem(EnumHand.MAIN_HAND);
        if(stack != null && stack.getItem() == ModItems.ringFlash && stack.getMetadata() == 1 ) {
            if (Keybindings.aktivate.isPressed()) {


            } else {


            }
        }

    }
  /*  @SubscribeEvent
    public void keyInputtow(InputEvent.KeyInputEvent event){
        Minecraft mc = Minecraft.getMinecraft();
        ItemStack stack = mc.thePlayer.getHeldItem();

        if(mc.gameSettings.keyBindJump.isKeyDown()){

        }


    }*/
}
