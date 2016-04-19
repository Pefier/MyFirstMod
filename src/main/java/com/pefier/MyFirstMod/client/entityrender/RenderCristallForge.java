package com.pefier.MyFirstMod.client.entityrender;

import com.pefier.MyFirstMod.entity.tileEntity.TileCristallForge;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by New Profile on 18.04.2016.
 */
public class RenderCristallForge extends TileEntitySpecialRenderer<TileCristallForge> {

    public static Minecraft mc = Minecraft.getMinecraft();

    @Override
    public void renderTileEntityAt(TileCristallForge forge, double x, double y, double z, float partialTicks, int destroyStage) {
        ItemStack input1 = forge.getStackInSlot(0);
        ItemStack input2 = forge.getStackInSlot(1);
        ItemStack output = forge.getStackInSlot(3);

        GlStateManager.pushMatrix();
        GlStateManager.translate(x,y,z);
        this.renderItem(forge.getWorld(),input1,partialTicks,0.7, 0.7, 0.2);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(x,y,z);
        this.renderItem(forge.getWorld(),input2,partialTicks,0.7, 0.7, 0.8);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(x,y,z);
        this.renderItem(forge.getWorld(),output,partialTicks,0.2, 0.7, 0.5);
        GlStateManager.popMatrix();


    }
    private void renderItem(World world, ItemStack stack, float ticks, double x, double y, double z){

        RenderItem itemRenderer = mc.getRenderItem();

        if(stack != null){
            GlStateManager.translate(x, y, z);
            EntityItem entityitem = new EntityItem(world, 0.0D, 0.0D, 0.0D, stack);
            //entityitem.getEntityItem().stackSize = 1;
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
