package com.pefier.MyFirstMod.handler;


import com.pefier.MyFirstMod.reference.Reference;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

/**
 * Created by New Profile on 06.03.2016.
 */
public class ConfigurationHandler {

    public static Configuration configuration;
    public static boolean configValue = false;

    public static void init(File configfile) {
        if(configuration == null) {

            configuration = new Configuration(configfile);
            configuration.load();
        }
    }
    public void loadConfiguration(){

        configValue = configuration.getBoolean("configValue", Configuration.CATEGORY_GENERAL, false, "This is an example configuration value");

        if (configuration.hasChanged()){

            configuration.save();
        }
    }
    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){

        if(event.getModID().equalsIgnoreCase(Reference.MOD_ID)){
           loadConfiguration();
        }
    }
}
