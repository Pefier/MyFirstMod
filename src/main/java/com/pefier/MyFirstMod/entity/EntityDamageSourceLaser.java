package com.pefier.MyFirstMod.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.translation.I18n;


/**
 * Created by New Profile on 14.04.2016.
 */
public class EntityDamageSourceLaser extends EntityDamageSourceIndirect {
    public EntityDamageSourceLaser(String name, Entity transmitter, Entity indirectEntityIn) {
        super(name, transmitter, indirectEntityIn);
        this.setDamageBypassesArmor();

    }

    @Override
    public ITextComponent getDeathMessage(EntityLivingBase target) {
        String s ="death.attack." +this.damageType;
        ITextComponent source = getEntity() == null ? getSourceOfDamage().getDisplayName() : this.getEntity().getDisplayName();
        ItemStack stack = (getEntity() != null && getEntity() instanceof EntityLivingBase) ? ((EntityLivingBase)getEntity()).getHeldItem(EnumHand.MAIN_HAND) : null;
        String s1 = s + ".item";

        return stack != null && stack.hasDisplayName() && I18n.canTranslate(s1) ? //StatCollector.canTranslate = I18n.can...
                new TextComponentTranslation(s1, target.getDisplayName(), source, stack.getChatComponent()) :
                new TextComponentTranslation(s, target.getDisplayName(), source);
    }
    public static EntityDamageSourceLaser causeLaserDamage(Entity source, Entity transmitter) {
        return new EntityDamageSourceLaser("laser.entity", transmitter, source);
    }
}
