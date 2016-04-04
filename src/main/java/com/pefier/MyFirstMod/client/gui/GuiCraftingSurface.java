package com.pefier.MyFirstMod.client.gui;

import com.pefier.MyFirstMod.reference.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

/**
 * Created by New Profile on 03.04.2016.
 */
public class GuiCraftingSurface extends GuiContainer {


    public static final ResourceLocation BACKGROUND = new ResourceLocation(Reference.MOD_ID +":textures/gui/CraftingSurface.png");


    public GuiCraftingSurface(Container inventorySlotsIn) {
        super(inventorySlotsIn);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        mc.renderEngine.bindTexture(BACKGROUND);
        int k = (this.width - this.xSize)/2;
        int l = (this.height - this.ySize)/2;
        drawTexturedModalRect(k,l,0,0,xSize,ySize);
    }
}
