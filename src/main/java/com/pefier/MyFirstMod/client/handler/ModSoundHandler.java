package com.pefier.MyFirstMod.client.handler;

import com.pefier.MyFirstMod.reference.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

/**
 * Created by New Profile on 20.04.2016.
 */
public class ModSoundHandler {

    public static SoundEvent laser;

    private  static int id;

    public static void init(){
        id=SoundEvent.soundEventRegistry.getKeys().size();
        laser = register("laser");


    }

    public static SoundEvent register(String name) {
        ResourceLocation location = new ResourceLocation(Reference.MOD_ID + ":" + name);
        SoundEvent event = new SoundEvent(location);
        SoundEvent.soundEventRegistry.register(id,location,event);
        id++;
        return event;

    }
}
