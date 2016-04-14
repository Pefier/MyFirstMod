package com.pefier.MyFirstMod.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.StatCollector;

/**
 * Created by New Profile on 14.04.2016.
 */
public class EntityDamageSourceLaser extends EntityDamageSourceIndirect {
    public EntityDamageSourceLaser(String name, Entity transmitter, Entity indirectEntityIn) {
        super(name, transmitter, indirectEntityIn);
        this.setDamageBypassesArmor();

    }

    @Override
    public IChatComponent getDeathMessage(EntityLivingBase target) {
        String s ="death.attack." +this.damageType;
        IChatComponent source = getEntity() == null ? getSourceOfDamage().getDisplayName() : this.getEntity().getDisplayName();
        ItemStack stack = (getEntity() != null && getEntity() instanceof EntityLivingBase) ? ((EntityLivingBase)getEntity()).getHeldItem() : null;
        String s1 = s + ".item";

        return stack != null && stack.hasDisplayName() && StatCollector.canTranslate(s1) ?
                new ChatComponentTranslation(s1, target.getDisplayName(), source, stack.getChatComponent()) :
                new ChatComponentTranslation(s, target.getDisplayName(), source);
    }
    public static EntityDamageSourceLaser causeLaserDamage(Entity source, Entity transmitter) {
        return new EntityDamageSourceLaser("laser.entity", transmitter, source);
    }
}
