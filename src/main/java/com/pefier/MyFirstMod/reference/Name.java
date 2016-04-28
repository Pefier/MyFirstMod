package com.pefier.MyFirstMod.reference;

/**
 * Created by New Profile on 18.03.2016.
 */
public final class Name {
    public static final class Keys {

        public static final String CATEGORY ="Keys.myfirstmod.category";
        public static final String AKTIVATE ="Keys.myfirstmod.aktivate";

    }
    public static  final class GuiIDs{
        public static final int GUI_CHARGER = 1;
        public static final int GUI_CRAFTING_SURFACE = 2;
        public static final int GUI_CRISTALLFORGE = 3;



    }
    public static final class NBTKey{

        public static final String TAG_RINGDATA="tag_ringdata";

        /**Changebale tags*/

        public static final String TAG_STATUS="tag_status";
        public static final String TAG_CHARGE="tag_charge";
        /**NON CHANGEBAL TAGS*/
        public static final String TAG_MAX_CHARGE="tag_max_charge";
        public static final String TAG_DMGREDUKTION="tag_dmgreduction";
        public static final String TAG_DMGINCREASE="tag_dmgincrease";
        public static final String TAG_RECHARGERATE="tag_rechargerate"; // for energy
        public static final String TAG_MININGSPEED="tag_miningspeed";
        public static final String TAG_JUMPHIGHT="tag_jumphight";
        public static final String TAG_ATTACKSPEED="tag_attackspeed";
    }
}
