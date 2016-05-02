package com.pefier.MyFirstMod.item;

import com.pefier.MyFirstMod.client.handler.ModSoundHandler;
import com.pefier.MyFirstMod.entity.throwabel.EntityLaser;
import com.pefier.MyFirstMod.reference.Name;
import com.pefier.MyFirstMod.reference.Reference;
import com.pefier.MyFirstMod.utility.NBTHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.lwjgl.input.Keyboard;

import java.util.*;

/**
 * Created by New Profile on 21.03.2016.
 */
public class ItemRingGreenLanter extends ItemMFM {

    private static final String name = "RingGreenLantern";

    private static UUID id = Reference.SPEED_MOD;


    public ItemRingGreenLanter(){
        super();
        setUnlocalizedName(name);
        setMaxStackSize(1);
        this.setRegistryName(Reference.MOD_ID,name);
        GameRegistry.register(this);
        setHasSubtypes(true);


    }

    public static String getName() {
        return name;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
        if(playerIn.isSneaking()) {

            if (NBTHelper.getNBTTagBoolean(itemStackIn, Name.NBTKey.TAG_STATUS, Name.NBTKey.TAG_RINGDATA) && NBTHelper.getNBTTagInt(itemStackIn, Name.NBTKey.TAG_CHARGE, Name.NBTKey.TAG_RINGDATA) > 0) {

                activate(playerIn,itemStackIn);
                NBTHelper.setNBTTagBoolean(itemStackIn, Name.NBTKey.TAG_STATUS, Name.NBTKey.TAG_RINGDATA, false);

            } else {

                deActivate(playerIn,itemStackIn);
                NBTHelper.setNBTTagBoolean(itemStackIn, Name.NBTKey.TAG_STATUS, Name.NBTKey.TAG_RINGDATA, true);

            }
            System.out.print(NBTHelper.getNBTTagInt(itemStackIn, Name.NBTKey.TAG_CHARGE, Name.NBTKey.TAG_RINGDATA));
        }else{
            if(!NBTHelper.getNBTTagBoolean(itemStackIn, Name.NBTKey.TAG_STATUS, Name.NBTKey.TAG_RINGDATA) &&  NBTHelper.getNBTTagInt(itemStackIn, Name.NBTKey.TAG_CHARGE, Name.NBTKey.TAG_RINGDATA) > 0){

                int charge = NBTHelper.getNBTTagInt(itemStackIn, Name.NBTKey.TAG_CHARGE, Name.NBTKey.TAG_RINGDATA);
                worldIn.playSound(playerIn,playerIn.posX,playerIn.posY,playerIn.posZ, ModSoundHandler.laser, SoundCategory.PLAYERS, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
                if (!worldIn.isRemote) {

                    EntityLaser entityLaser = new EntityLaser(worldIn, playerIn);
                    entityLaser.func_184538_a(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.3F, 0.0F);
                    worldIn.spawnEntityInWorld(entityLaser);

                    charge-= 15 ;
                    NBTHelper.setNBTTagInt(itemStackIn, Name.NBTKey.TAG_CHARGE, Name.NBTKey.TAG_RINGDATA, charge);
                }
            }

        }
            return new ActionResult<ItemStack>(EnumActionResult.PASS,itemStackIn);
    }

    @Override
    public void onUpdate(ItemStack itemStackIn, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        super.onUpdate(itemStackIn, worldIn, entityIn, itemSlot, isSelected);
        if(itemStackIn.hasTagCompound()) {
            int charge = NBTHelper.getNBTTagInt(itemStackIn, Name.NBTKey.TAG_CHARGE, Name.NBTKey.TAG_RINGDATA);
                if (NBTHelper.getNBTTagInt(itemStackIn, Name.NBTKey.TAG_CHARGE, Name.NBTKey.TAG_RINGDATA) > 0 && !NBTHelper.getNBTTagBoolean(itemStackIn, Name.NBTKey.TAG_STATUS, Name.NBTKey.TAG_RINGDATA)) {
                    charge--;
                    NBTHelper.setNBTTagInt(itemStackIn, Name.NBTKey.TAG_CHARGE, Name.NBTKey.TAG_RINGDATA, charge);
                }
                if (NBTHelper.getNBTTagInt(itemStackIn, Name.NBTKey.TAG_CHARGE, Name.NBTKey.TAG_RINGDATA) <= 0) {
                    if (entityIn instanceof EntityPlayer) {

                        deActivate((EntityPlayer) entityIn, itemStackIn);

                        NBTHelper.setNBTTagBoolean(itemStackIn, Name.NBTKey.TAG_STATUS, Name.NBTKey.TAG_RINGDATA, true);
                    }
                }
        }

    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "." + (stack.getItemDamage() == 0 ? "aktive" : "normal");
    }

    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List subItems) {
        subItems.add(new ItemStack(itemIn, 1, 0));
        subItems.add(new ItemStack(itemIn, 1, 1));
    }

    private void activate(EntityPlayer playerIn, ItemStack itemStackIn){

        playerIn.capabilities.allowFlying = true;
        playerIn.capabilities.isFlying = true;
        if(playerIn.getEntityAttribute(SharedMonsterAttributes.ATTACK_SPEED).getModifier(id) == null) {
            playerIn.getEntityAttribute(SharedMonsterAttributes.ATTACK_SPEED).applyModifier(new AttributeModifier(id,"Speedmod",NBTHelper.getNBTTagDouble(itemStackIn,Name.NBTKey.TAG_ATTACKSPEED,Name.NBTKey.TAG_RINGDATA),0));
        }
        System.out.println("aktive");
        itemStackIn.setItemDamage(1);

    }

    private void deActivate(EntityPlayer playerIn, ItemStack itemStackIn){

        playerIn.capabilities.allowFlying = false;
        playerIn.capabilities.isFlying = false;
        if(playerIn.getEntityAttribute(SharedMonsterAttributes.ATTACK_SPEED).getModifier(id) != null) {
            playerIn.getEntityAttribute(SharedMonsterAttributes.ATTACK_SPEED).removeModifier(id);
        }

        System.out.println("inaktiv");
        itemStackIn.setItemDamage(0);

    }

    @Override //is ClientSide only
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, playerIn, tooltip, advanced);
        tooltip.add("Press Shift for information");

        if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)||Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
            tooltip.add(NBTHelper.printNBTInt(stack,Name.NBTKey.TAG_DMGREDUKTION,Name.NBTKey.TAG_RINGDATA,"Damage Reduktion: "));
            tooltip.add(NBTHelper.printNBTDouble(stack,Name.NBTKey.TAG_ATTACKSPEED,Name.NBTKey.TAG_RINGDATA,"Attack Speed: "));
            tooltip.add(NBTHelper.printNBTInt(stack,Name.NBTKey.TAG_DMGINCREASE,Name.NBTKey.TAG_RINGDATA,"Laser Damage: "));
        }


    }
}