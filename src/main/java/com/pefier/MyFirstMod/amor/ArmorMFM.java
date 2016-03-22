package com.pefier.MyFirstMod.amor;


import com.pefier.MyFirstMod.creativtab.CreativeTabMFM;
import com.pefier.MyFirstMod.proxy.ClientProxy;
import com.pefier.MyFirstMod.reference.Reference;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;



/**
 * Created by New Profile on 13.03.2016.
 */
public class ArmorMFM extends ItemArmor {

    public ArmorMFM(ArmorMaterial material, int renderIndex, int armorType) {
        super(material, renderIndex, armorType);
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
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemstack, int armorSlot , ModelBiped _default) {

        ModelBiped armorModel =  ClientProxy.armorModels.get(this);
        armorModel.setModelAttributes(_default);

        if (armorModel != null) {

            armorModel.bipedHead.showModel = armorSlot == 0;
            armorModel.bipedHeadwear.showModel = false;
            armorModel.bipedBody.showModel = armorSlot == 1 || armorSlot == 2;
            armorModel.bipedRightArm.showModel = armorSlot == 1;
            armorModel.bipedLeftArm.showModel = armorSlot == 1;
            armorModel.bipedRightLeg.showModel = armorSlot == 2 || armorSlot == 3;
            armorModel.bipedLeftLeg.showModel = armorSlot == 2 || armorSlot == 3;

        }
        return armorModel;
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer) {

        String name = this.getUnwrappedUnlocalizedName(super.getUnlocalizedName());
        name = name.substring(0, name.indexOf('_'));
        return String.format("%s:textures/models/%s_layer_%d.png", Reference.MOD_ID.toLowerCase(), name, slot == 2 ? 2 : 1);
    }

}
