package com.pefier.MyFirstMod.item;

import com.pefier.MyFirstMod.entity.entityfx.LighningTest.LightningBolt;
import com.pefier.MyFirstMod.entity.entityfx.LighningTest.Vector3;
import com.pefier.MyFirstMod.reference.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 The TestBlaster only use to test things.
 */
public class ItemBlaster extends ItemMFM {

    private static final String name = "Blaster";

    public ItemBlaster(){
        super();
        this.setRegistryName(Reference.MOD_ID,name);
        GameRegistry.register(this);
        setMaxStackSize(1);
        setUnlocalizedName(name);

    }

    public static String getName() {
        return name;
    }
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer player, EnumHand hand)
    {

        if(worldIn.isRemote) {
            Vec3d entityVector = new Vec3d(player.posX + player.width / 2, player.posY + player.getEyeHeight(), player.posZ + player.width / 2);
            Vec3d entityLook = player.getLookVec();
            int range = 8;
            Vec3d finalVector = entityVector.addVector(entityLook.xCoord * range, entityLook.yCoord * range, entityLook.zCoord * range);
            LightningBolt bolt = new LightningBolt(worldIn, Vector3.fromEntity(player), Vector3.fromVec3(finalVector), 0xFF00DE, player.worldObj.rand.nextLong(), 0xCC00FF, 0xFF00DE);
            bolt.defaultFractal();
            bolt.finalizeBolt();
            LightningBolt.boltlist.add(bolt);

        }

        return new ActionResult(EnumActionResult.PASS, itemStackIn);
    }
}
