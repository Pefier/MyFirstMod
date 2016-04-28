package com.pefier.MyFirstMod.client.entityrender;

import com.pefier.MyFirstMod.entity.tileEntity.TileCharger;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by New Profile on 18.04.2016.
 */
public class RenderCharger extends TileEntitySpecialRenderer<TileCharger> {

    public static Minecraft mc = Minecraft.getMinecraft();



    @Override
    public void renderTileEntityAt(TileCharger charger, double x, double y, double z, float partialTicks, int destroyStage) {
        ItemStack input = charger.getStackInSlot(0);

        GlStateManager.pushMatrix();
        GlStateManager.translate(x,y,z);
        this.renderItem(charger.getWorld(),input,partialTicks);
        GlStateManager.popMatrix();


    }

    private void renderItem(World world, ItemStack stack, float ticks){

        RenderItem itemRenderer = mc.getRenderItem();

        if(stack != null){
            GlStateManager.translate(0.5, 0.6, 0.5);
            EntityItem entityitem = new EntityItem(world, 0.0D, 0.0D, 0.0D, stack);
            entityitem.getEntityItem().stackSize = 1;
            entityitem.hoverStart = 0.0F;
            GlStateManager.pushMatrix();
            GlStateManager.disableLighting();

            float rotation = (float) (720.0 * (System.currentTimeMillis() & 0x3FFFL) / 0x3FFFL);

            GlStateManager.rotate(rotation, 0.0F, 1.0F, 0);
            GlStateManager.scale(0.3F, 0.3F, 0.3F);
            GlStateManager.pushAttrib();
            RenderHelper.enableStandardItemLighting();
            itemRenderer.renderItem(entityitem.getEntityItem(), ItemCameraTransforms.TransformType.FIXED);
            RenderHelper.disableStandardItemLighting();
            GlStateManager.popAttrib();
            GlStateManager.enableLighting();
            GlStateManager.popMatrix();
        }


    }
}
