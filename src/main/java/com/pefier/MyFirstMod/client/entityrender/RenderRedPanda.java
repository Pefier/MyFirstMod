package com.pefier.MyFirstMod.client.entityrender;


import com.pefier.MyFirstMod.Mob.EntityRedPanda;
import com.pefier.MyFirstMod.reference.Reference;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

/**
 * Created by New Profile on 07.03.2016.
 */
public class RenderRedPanda extends RenderLiving<EntityRedPanda> {

    public static Factory FACTORY = new Factory();

    public RenderRedPanda(RenderManager renderManager ) {
        super(renderManager, new ModelRedPanda(), 0.5f);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityRedPanda entity) {
        return new ResourceLocation(Reference.MOD_ID, "textures/entity/RedPanda.png");
    }

    public static class Factory implements IRenderFactory<EntityRedPanda>{

        @Override
        public Render<? super EntityRedPanda> createRenderFor(RenderManager manager) {
            return new RenderRedPanda(manager);
        }
    }



}
