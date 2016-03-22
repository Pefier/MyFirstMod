package com.pefier.MyFirstMod.item;

import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by New Profile on 21.03.2016.
 */
public class ItemGreenLanterRing extends ItemMFM {

    private static final String name = "GreenLanternRing";

    private static final String TAG_FLASH = "tag_lantern";
    private static final String TAG_STATUS ="tag_power";

    public  ItemGreenLanterRing(){
        super();
        setUnlocalizedName(name);
        setMaxStackSize(1);
        GameRegistry.registerItem(this, name);


    }

    public static String getName() {
        return name;
    }


}
