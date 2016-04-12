package com.pefier.MyFirstMod.client.gui;

import com.pefier.MyFirstMod.container.ContainerCirstallForge;
import com.pefier.MyFirstMod.reference.Reference;
import com.pefier.MyFirstMod.tileEntity.TileCristallForge;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

/**
 * Created by New Profile on 24.03.2016.
 */
public class GuiCristallForge extends GuiContainer {

    public static final ResourceLocation BACKGROUND = new ResourceLocation(Reference.MOD_ID +":textures/gui/CristallForge.png");
    private TileCristallForge cristallForge;

    public GuiCristallForge(InventoryPlayer playerInv, TileCristallForge cristallForge) {
        super(new ContainerCirstallForge(playerInv,cristallForge));
        this.cristallForge = cristallForge;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        mc.renderEngine.bindTexture(BACKGROUND);
        int i = (this.width - this.xSize)/2;
        int j = (this.height - this.ySize)/2;
        drawTexturedModalRect(i,j,0,0,xSize,ySize);

        int l = this.getProgressScaled(24);
                                    //ingame x,y textur x,y
        this.drawTexturedModalRect(i + 89, j + 34, 176, 14, l + 1, 16);


    }



    private int getProgressScaled(int pixels)
    {
        int i = this.cristallForge.getField(2);
        int j = this.cristallForge.getField(3);
        return j != 0 && i != 0 ? i * pixels / j : 0;
    }




}
