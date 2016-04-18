package com.pefier.MyFirstMod.item;


import com.pefier.MyFirstMod.creativtab.CreativeTabMFM;
import com.pefier.MyFirstMod.proxy.ClientProxy;
import com.pefier.MyFirstMod.reference.Reference;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;



/**
 * Created by New Profile on 13.03.2016.
 */
public class ArmorMFM extends ItemArmor {

    public ArmorMFM(ArmorMaterial material, int renderIndex, EntityEquipmentSlot equipmentSlotIn) {
        super(material, renderIndex, equipmentSlotIn);
        setMaxStackSize(1);
        setCreativeTab(CreativeTabMFM.MY_TAB);
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("item.%s%s", (Reference.MOD_ID + ":"), getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        return String.format("item.%s%s", (Reference.MOD_ID + ":"), getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf('.') + 1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemstack, EntityEquipmentSlot armorSlot , ModelBiped _default) {

        ModelBiped armorModel =  ClientProxy.armorModels.get(this);
        armorModel.setModelAttributes(_default);

        if (armorModel != null) {

            armorModel.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
            armorModel.bipedHeadwear.showModel = false;
            armorModel.bipedBody.showModel = armorSlot == EntityEquipmentSlot.CHEST || armorSlot == EntityEquipmentSlot.LEGS;
            armorModel.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
            armorModel.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
            armorModel.bipedRightLeg.showModel = armorSlot == EntityEquipmentSlot.LEGS || armorSlot == EntityEquipmentSlot.FEET;
            armorModel.bipedLeftLeg.showModel = armorSlot == EntityEquipmentSlot.LEGS || armorSlot == EntityEquipmentSlot.FEET;

        }
        return armorModel;
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String layer) {

        String name = this.getUnwrappedUnlocalizedName(super.getUnlocalizedName());
        name = name.substring(0, name.indexOf('_'));
        return String.format("%s:textures/models/%s_layer_%d.png", Reference.MOD_ID.toLowerCase(), name, slot == EntityEquipmentSlot.LEGS ? 2 : 1);
    }

}
