package com.pefier.MyFirstMod.creativtab;

import com.pefier.MyFirstMod.init.ModItems;
import com.pefier.MyFirstMod.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by New Profile on 11.03.2016.
 */
public class CreativeTabMFM {

    public static final CreativeTabs MY_TAB = new CreativeTabs(Reference.MOD_ID) {
        @Override
        public Item getTabIconItem() {
            return ModItems.bambus;
        }
        @Override
        public String getTranslatedTabLabel(){
            return Reference.MOD_NAME ;
        }
    };
}
