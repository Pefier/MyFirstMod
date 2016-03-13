package com.pefier.MyFirstMod.amor;

import com.pefier.MyFirstMod.amorModels.ModelFlashArmor;
import com.pefier.MyFirstMod.creativtab.CreativeTabMFM;
import com.pefier.MyFirstMod.proxy.ClientProxy;
import com.pefier.MyFirstMod.reference.Reference;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
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
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemstack, int armorSlot) {    //line 900 Item.java

        ModelFlashArmor armorModel = (ModelFlashArmor) ClientProxy.armorModels.get(this);

        if (armorModel != null) {

            armorModel.bipedHead.showModel = armorSlot == 0;
            armorModel.bipedHeadwear.showModel = false;
            armorModel.bipedBody.showModel = armorSlot == 1 || armorSlot == 2;
            armorModel.bipedRightArm.showModel = armorSlot == 1;
            armorModel.bipedLeftArm.showModel = armorSlot == 1;
            armorModel.bipedRightLeg.showModel = armorSlot == 2 || armorSlot == 3;
            armorModel.bipedLeftLeg.showModel = armorSlot == 2 || armorSlot == 3;


            armorModel.isSneak = entityLiving.isSneaking();
            armorModel.isRiding = entityLiving.isRiding();
            armorModel.isChild = entityLiving.isChild();

            armorModel.heldItemRight = 0;
            armorModel.aimedBow = false;

            EntityPlayer player = (EntityPlayer) entityLiving;

            ItemStack held_item = player.getEquipmentInSlot(0);

            if (held_item != null) {
                armorModel.heldItemRight = 1;

                if (player.getItemInUseCount() > 0) {

                    EnumAction enumaction = held_item.getItemUseAction();

                    if (enumaction == EnumAction.BOW) {
                        armorModel.aimedBow = true;
                    } else if (enumaction == EnumAction.BLOCK) {
                        armorModel.heldItemRight = 3;
                    }


                }

            }


        }


        return armorModel;
    }


    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer) { //line 860 item.java

        String name = this.getUnwrappedUnlocalizedName(super.getUnlocalizedName());
        name = name.substring(0, name.indexOf('_'));
        return String.format("%s:textures/models/%s_layer_%d.png", Reference.MOD_ID.toLowerCase(), name, slot == 2 ? 2 : 1);
    }
}
