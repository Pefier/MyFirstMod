package com.pefier.MyFirstMod.render;

import com.pefier.MyFirstMod.Mob.EntityRedPanda;
import com.pefier.MyFirstMod.client.entityrender.RenderRedPanda;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

/**
 * Created by New Profile on 17.03.2016.
 */
public class EntityRenderRegister {
    public static void preinit(){

        RenderingRegistry.registerEntityRenderingHandler(EntityRedPanda.class, RenderRedPanda.FACTORY);
    }
}
