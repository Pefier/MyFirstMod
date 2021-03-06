package com.pefier.MyFirstMod.client.gui;

import com.pefier.MyFirstMod.container.ContainerCirstallForge;
import com.pefier.MyFirstMod.container.ContainerCraftingSurface;
import com.pefier.MyFirstMod.reference.Name;
import com.pefier.MyFirstMod.container.ContainerCharger;
import com.pefier.MyFirstMod.entity.tileEntity.TileCharger;
import com.pefier.MyFirstMod.entity.tileEntity.TileCristallForge;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

/**
 * Created by New Profile on 24.03.2016.
 */
public class GuiHandler implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID){
            case Name.GuiIDs.GUI_CHARGER: return new ContainerCharger(player.inventory, (TileCharger) world.getTileEntity(new BlockPos(x,y,z)));
            case Name.GuiIDs.GUI_CRAFTING_SURFACE: return new ContainerCraftingSurface(player.inventory,world, x,y,z);
            case Name.GuiIDs.GUI_CRISTALLFORGE: return  new ContainerCirstallForge(player.inventory,(TileCristallForge)world.getTileEntity(new BlockPos(x,y,z)));
            default: return null;
        }




    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch(ID) {
            case Name.GuiIDs.GUI_CHARGER: return new GuiCharger(new ContainerCharger(player.inventory, (TileCharger) world.getTileEntity(new BlockPos(x,y,z))));
            case Name.GuiIDs.GUI_CRAFTING_SURFACE:return new GuiCraftingSurface(new ContainerCraftingSurface(player.inventory,world, x,y,z));
            case Name.GuiIDs.GUI_CRISTALLFORGE: return  new GuiCristallForge(player.inventory,(TileCristallForge)world.getTileEntity(new BlockPos(x,y,z)));
            default: return null;
        }
    }
}
