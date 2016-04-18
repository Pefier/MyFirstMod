package com.pefier.MyFirstMod.client.handler;


import com.pefier.MyFirstMod.init.ModItems;
import com.pefier.MyFirstMod.reference.Name;
import com.pefier.MyFirstMod.reference.Reference;
import com.pefier.MyFirstMod.utility.InventoryHelper;
import com.pefier.MyFirstMod.utility.NBTHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;



/**
 * Created by New Profile on 24.03.2016.
 */
public class OverlayHandler {
    @SubscribeEvent
    public void onRenderGameoverlay(RenderGameOverlayEvent event){

        if(!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.EXPERIENCE){
            Minecraft mc = Minecraft.getMinecraft();

            if(!mc.thePlayer.capabilities.isCreativeMode){
                if(mc.thePlayer.inventory.hasItemStack(new ItemStack(ModItems.ringGreenLantern))){
                    if(InventoryHelper.getItemStackinInventory(mc.thePlayer,ModItems.ringGreenLantern).hasTagCompound()&& InventoryHelper.getItemStackinInventory(mc.thePlayer,ModItems.ringGreenLantern).getMetadata()==1 ){

                        int Full = (NBTHelper.getNBTTagInt(InventoryHelper.getItemStackinInventory(mc.thePlayer,ModItems.ringGreenLantern), Name.NBTKey.TAG_CHARGE ,Name.NBTKey.TAG_RINGDATA)/100);

                        int posX = (event.getResolution().getScaledWidth()/2 -50);
                        int posY = (event.getResolution().getScaledHeight()-54);
                        //int Full = 48; //0 < full < 98 max
                        mc.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID+":textures/gui/bar.png"));
                        mc.ingameGUI.drawTexturedModalRect(posX,posY,0,0,100,14);
                        mc.ingameGUI.drawTexturedModalRect(posX+1,posY+1,0,14,Full,12);
                    }
                }
            }
        }
    }
}
