package com.pefier.MyFirstMod.client.entityrender;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

/**
 * Created by New Profile on 07.03.2016.
 */
public class ModelRedPanda extends ModelBase {
    //fields
    ModelRenderer WolfHead;
    ModelRenderer Body;
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Leg3;
    ModelRenderer Leg4;
    ModelRenderer Tail;
    ModelRenderer Tail2;
    ModelRenderer Ear1;
    ModelRenderer Ear2;
    ModelRenderer Nose;

    public ModelRedPanda()
    {
        textureWidth = 64;
        textureHeight = 32;

        WolfHead = new ModelRenderer(this, 0, 0);
        WolfHead.addBox(-3F, -3F, -2F, 6, 6, 4);
        WolfHead.setRotationPoint(-1F, 15.3F, -7F);
        WolfHead.setTextureSize(64, 32);
        WolfHead.mirror = true;
        setRotation(WolfHead, 0F, 0F, 0F);
        Body = new ModelRenderer(this, 23, 0);
        Body.addBox(-4F, -2F, -3F, 6, 13, 6);
        Body.setRotationPoint(0F, 16F, -3F);
        Body.setTextureSize(64, 32);
        Body.mirror = true;
        setRotation(Body, 1.570796F, 0F, 0F);
        Leg1 = new ModelRenderer(this, 0, 18);
        Leg1.addBox(-1F, 0F, -1F, 2, 4, 2);
        Leg1.setRotationPoint(-2.5F, 19F, 6F);
        Leg1.setTextureSize(64, 32);
        Leg1.mirror = true;
        setRotation(Leg1, 0F, 0F, 0F);
        Leg2 = new ModelRenderer(this, 0, 18);
        Leg2.addBox(-1F, 0F, -1F, 2, 4, 2);
        Leg2.setRotationPoint(0.5F, 19F, 6F);
        Leg2.setTextureSize(64, 32);
        Leg2.mirror = true;
        setRotation(Leg2, 0F, 0F, 0F);
        Leg3 = new ModelRenderer(this, 0, 18);
        Leg3.addBox(-1F, 0F, -1F, 2, 4, 2);
        Leg3.setRotationPoint(-2.5F, 19F, -4F);
        Leg3.setTextureSize(64, 32);
        Leg3.mirror = true;
        setRotation(Leg3, 0F, 0F, 0F);
        Leg4 = new ModelRenderer(this, 0, 18);
        Leg4.addBox(-1F, 0F, -1F, 2, 4, 2);
        Leg4.setRotationPoint(0.5F, 19F, -4F);
        Leg4.setTextureSize(64, 32);
        Leg4.mirror = true;
        setRotation(Leg4, 0F, 0F, 0F);
        Tail = new ModelRenderer(this, 9, 18);
        Tail.addBox(-1F, 0F, -1F, 3, 5, 3);
        Tail.setRotationPoint(-1.466667F, 15F, 7F);
        Tail.setTextureSize(64, 32);
        Tail.mirror = true;
        setRotation(Tail, 1.130069F, 0F, 0F);
        Tail2 = new ModelRenderer(this, 35, 20);
        Tail2.addBox(-1F, 4F, -2F, 3, 7, 3);
        Tail2.setRotationPoint(-1.5F, 15F, 7F);
        Tail2.setTextureSize(64, 32);
        Tail2.mirror = true;
        setRotation(Tail2, 1.329831F, 0F, 0F);
        Ear1 = new ModelRenderer(this, 9, 12);
        Ear1.addBox(-3F, -4F, 0F, 2, 2, 1);
        Ear1.setRotationPoint(-1F, 15.3F, -7F);
        Ear1.setTextureSize(64, 32);
        Ear1.mirror = true;
        setRotation(Ear1, 0F, -0.1487144F, -0.0733038F);
        Ear2 = new ModelRenderer(this, 16, 12);
        Ear2.addBox(1F, -4F, 0F, 2, 2, 1);
        Ear2.setRotationPoint(-1F, 15.3F, -7F);
        Ear2.setTextureSize(64, 32);
        Ear2.mirror = true;
        setRotation(Ear2, 0F, 0.1523153F, 0.0767945F);
        Nose = new ModelRenderer(this, 0, 11);
        Nose.addBox(-1.5F, -1F, -3F, 3, 3, 1);
        Nose.setRotationPoint(-1F, 15.3F, -7F);
        Nose.setTextureSize(64, 32);
        Nose.mirror = true;
        setRotation(Nose, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        WolfHead.render(f5);
        Body.render(f5);
        Leg1.render(f5);
        Leg2.render(f5);
        Leg3.render(f5);
        Leg4.render(f5);
        Tail.render(f5);
        Tail2.render(f5);
        Ear1.render(f5);
        Ear2.render(f5);
        Nose.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);


        this.WolfHead.rotateAngleX = f5 / (180F / (float)Math.PI);
        this.WolfHead.rotateAngleY = f4 / (180F / (float)Math.PI);
        this.Nose.rotateAngleX = f5 / (180F / (float)Math.PI);
        this.Nose.rotateAngleY = f4 / (180F / (float)Math.PI);
        this.Ear1.rotateAngleX = f5 / (180F / (float)Math.PI);
        this.Ear1.rotateAngleY = f4 / (180F / (float)Math.PI);
        this.Ear2.rotateAngleX = f5 / (180F / (float)Math.PI);
        this.Ear2.rotateAngleY = f4 / (180F / (float)Math.PI);
        this.Leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.Leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
        this.Leg3.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
        this.Leg4.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.Leg1.rotateAngleY = 0.0F;
        this.Leg2.rotateAngleY = 0.0F;
        this.Leg3.rotateAngleY = 0.0F;
        this.Leg4.rotateAngleY = 0.0F;


    }

}
