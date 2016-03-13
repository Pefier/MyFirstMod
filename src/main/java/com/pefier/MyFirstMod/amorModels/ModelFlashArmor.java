package com.pefier.MyFirstMod.amorModels;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.texture.Stitcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;

/**
 * Created by New Profile on 13.03.2016.
 */
public class ModelFlashArmor extends ModelBiped {

    ModelRenderer body;
    ModelRenderer head;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer EarLeft1;
    ModelRenderer EarRight1;
    ModelRenderer EarRight2;
    ModelRenderer EarLeft2;

    public ModelFlashArmor(float expand)
    {
        super(expand,0,64,64 );



        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -8F, -4F, 8, 8, 8);
        head.setRotationPoint(0F, 0F, 0F);
        head.setTextureSize(64, 64);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);

        body = new ModelRenderer(this, 16, 16);
        body.addBox(-4F, 0F, -2F, 8, 12, 4);
        body.setRotationPoint(0F, 0F, 0F);
        body.setTextureSize(64, 64);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);

        rightarm = new ModelRenderer(this, 40, 16);
        rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
        rightarm.setRotationPoint(-5F, 2F, 0F);
        rightarm.setTextureSize(64, 64);
        rightarm.mirror = true;
        setRotation(rightarm, 0F, 0F, 0F);
        leftarm = new ModelRenderer(this, 40, 16);
        leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
        leftarm.setRotationPoint(5F, 2F, 0F);
        leftarm.setTextureSize(64, 64);
        leftarm.mirror = true;
        setRotation(leftarm, 0F, 0F, 0F);

        rightleg = new ModelRenderer(this, 0, 16);
        rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        rightleg.setRotationPoint(-2F, 12F, 0F);
        rightleg.setTextureSize(64, 64);
        rightleg.mirror = true;
        setRotation(rightleg, 0F, 0F, 0F);
        leftleg = new ModelRenderer(this, 0, 32);
        leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        leftleg.setRotationPoint(2F, 12F, 0F);
        leftleg.setTextureSize(64, 64);
        leftleg.mirror = true;
        setRotation(leftleg, 0F, 0F, 0F);

        EarLeft1 = new ModelRenderer(this, 0, 0);
        EarLeft1.addBox(5F, -5F, 0F, 1, 1, 2);
        EarLeft1.setRotationPoint(0F, 0F, 0F);
        EarLeft1.setTextureSize(64, 64);
        EarLeft1.mirror = true;
        setRotation(EarLeft1, 0F, 0F, 0F);
        EarRight1 = new ModelRenderer(this, 0, 0);
        EarRight1.addBox(-6F, -5F, 0F, 1, 1, 2);
        EarRight1.setRotationPoint(0F, 0F, 0F);
        EarRight1.setTextureSize(64, 32);
        EarRight1.mirror = true;
        setRotation(EarRight1, 0F, 0F, 0F);
        EarRight2 = new ModelRenderer(this, 0, 0);
        EarRight2.addBox(-6F, -6F, 1F, 1, 1, 2);
        EarRight2.setRotationPoint(0F, 0F, 0F);
        EarRight2.setTextureSize(64, 64);
        EarRight2.mirror = true;
        setRotation(EarRight2, 0F, 0F, 0F);
        EarLeft2 = new ModelRenderer(this, 0, 0);
        EarLeft2.addBox(5F, -6F, 1F, 1, 1, 2);
        EarLeft2.setRotationPoint(0F, 0F, 0F);
        EarLeft2.setTextureSize(64, 64);
        EarLeft2.mirror = true;
        setRotation(EarLeft2, 0F, 0F, 0F);

        EarLeft1.addChild(EarLeft2);
        EarRight1.addChild(EarRight2);
        head.addChild(EarLeft1);
        head.addChild(EarRight1);

    }


    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);

    }



    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }






}
