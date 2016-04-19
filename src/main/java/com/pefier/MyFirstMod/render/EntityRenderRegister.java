package com.pefier.MyFirstMod.render;

import com.pefier.MyFirstMod.client.entityrender.RenderCharger;
import com.pefier.MyFirstMod.client.entityrender.RenderCristallForge;
import com.pefier.MyFirstMod.client.entityrender.RenderLaser;
import com.pefier.MyFirstMod.entity.living.EntityRedPanda;
import com.pefier.MyFirstMod.client.entityrender.RenderRedPanda;
import com.pefier.MyFirstMod.entity.throwabel.EntityLaser;
import com.pefier.MyFirstMod.entity.tileEntity.TileCharger;
import com.pefier.MyFirstMod.entity.tileEntity.TileCristallForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

/**
 * Created by New Profile on 17.03.2016.
 */
public class EntityRenderRegister {
    public static void preinit(){

        RenderingRegistry.registerEntityRenderingHandler(EntityRedPanda.class, RenderRedPanda.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityLaser.class, RenderLaser.FACTORY);

        ClientRegistry.bindTileEntitySpecialRenderer(TileCharger.class,new RenderCharger());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCristallForge.class,new RenderCristallForge());
    }
}
