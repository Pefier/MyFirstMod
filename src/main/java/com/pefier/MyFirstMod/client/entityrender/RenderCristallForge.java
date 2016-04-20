package com.pefier.MyFirstMod.client.entityrender;

import com.pefier.MyFirstMod.block.BlockCristallForge;
import com.pefier.MyFirstMod.entity.tileEntity.TileCristallForge;
import com.pefier.MyFirstMod.init.ModBlocks;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EnumFaceDirection;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
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

        float rot = -90;

        IBlockState state = forge.getWorld().getBlockState(forge.getPos());
        if(state.getBlock() != ModBlocks.cristallForge)
            return;

        IBlockState actualstate = state.getBlock().getActualState(state,forge.getWorld(), forge.getPos());
        EnumFacing facing = actualstate.getValue(BlockCristallForge.FACING);
        switch(facing) {
            case SOUTH:
                rot = 90F;
                break;
            case EAST:
                rot = 180F;
                break;
            case WEST:
                rot = 0F;
                break;
            default: break;
        }




        GlStateManager.pushMatrix();
        GlStateManager.translate(x,y,z);
        GlStateManager.translate(0.5, 0, 0.5);

        GlStateManager.rotate(rot,0F,1F,0F);
        this.renderItem(forge.getWorld(),input1,partialTicks,0.2, 0.7, -0.3);

        GlStateManager.popMatrix();

        GlStateManager.pushMatrix();
        GlStateManager.translate(x,y,z);
        GlStateManager.translate(0.5, 0, 0.5);
        GlStateManager.rotate(rot,0F,1F,0F);
        this.renderItem(forge.getWorld(),input2,partialTicks,0.2, 0.7, 0.3);

        GlStateManager.popMatrix();

        GlStateManager.pushMatrix();
        GlStateManager.translate(x,y,z);
        GlStateManager.translate(0.5, 0, 0.5);
        GlStateManager.rotate(rot,0F,1F,0F);
        this.renderItem(forge.getWorld(),output,partialTicks,-0.25, 0.7, 0.0);

        GlStateManager.popMatrix();


    }
    private void renderItem(World world, ItemStack stack, float ticks, double x, double y, double z){

        RenderItem itemRenderer = mc.getRenderItem();

        if(stack != null){
            GlStateManager.translate(x, y, z);
            EntityItem entityitem = new EntityItem(world, 0.0D, 0.0D, 0.0D, stack);
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
