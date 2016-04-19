package com.pefier.MyFirstMod.item;

import com.pefier.MyFirstMod.reference.Name;
import com.pefier.MyFirstMod.reference.Reference;
import com.pefier.MyFirstMod.utility.NBTHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Pefier on 10.03.2016.
 */
public class ItemRingCold extends ItemMFM{
    public final String name ="RingCold";

    public ItemRingCold(){
        super();
        this.setRegistryName(Reference.MOD_ID,name);
        GameRegistry.register(this);
        setUnlocalizedName(name);
        setMaxStackSize(1);

    }
    public String getName(){
        return name;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand){


            if (NBTHelper.getNBTTagBoolean(itemStackIn, Name.NBTKey.TAG_STATUS, Name.NBTKey.TAG_RINGDATA)) {
                System.out.println(NBTHelper.getNBTTagInt(itemStackIn, Name.NBTKey.TAG_MAX_CHARGE, Name.NBTKey.TAG_RINGDATA));
                System.out.println(NBTHelper.getNBTTagInt(itemStackIn, Name.NBTKey.TAG_RECHARGERATE, Name.NBTKey.TAG_RINGDATA));
                System.out.println(NBTHelper.getNBTTagInt(itemStackIn, Name.NBTKey.TAG_DMGINCREASE, Name.NBTKey.TAG_RINGDATA));
                System.out.println(NBTHelper.getNBTTagInt(itemStackIn, Name.NBTKey.TAG_DMGREDUKTION, Name.NBTKey.TAG_RINGDATA));
                System.out.println(NBTHelper.getNBTTagInt(itemStackIn, Name.NBTKey.TAG_JUMPHIGHT, Name.NBTKey.TAG_RINGDATA));
                System.out.println(NBTHelper.getNBTTagInt(itemStackIn, Name.NBTKey.TAG_MININGSPEED, Name.NBTKey.TAG_RINGDATA));


                NBTHelper.setNBTTagBoolean(itemStackIn, Name.NBTKey.TAG_STATUS, Name.NBTKey.TAG_RINGDATA, false);
            } else {


                NBTHelper.setNBTTagBoolean(itemStackIn, Name.NBTKey.TAG_STATUS, Name.NBTKey.TAG_RINGDATA, true);
            }












        return new ActionResult(EnumActionResult.PASS, itemStackIn);
    }
}
