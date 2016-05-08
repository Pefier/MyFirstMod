package com.pefier.MyFirstMod.proxy;

import com.pefier.MyFirstMod.client.handler.KeyHandler;
import com.pefier.MyFirstMod.client.handler.OverlayHandler;
import com.pefier.MyFirstMod.crafting.VanillaRecepies;
import com.pefier.MyFirstMod.handler.ConfigurationHandler;
import com.pefier.MyFirstMod.handler.FlashHandler;
import com.pefier.MyFirstMod.handler.RingHandler;
import com.pefier.MyFirstMod.handler.WorldGenerator;
import com.pefier.MyFirstMod.init.ModBlocks;
import com.pefier.MyFirstMod.init.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by New Profile on 06.03.2016.
 */
public abstract class CommonProxy {
    public void preInit(FMLPreInitializationEvent e) {
        ModItems.preinit();
        ModBlocks.preinit();

        MinecraftForge.EVENT_BUS.register(new ConfigurationHandler());
        MinecraftForge.EVENT_BUS.register(new FlashHandler());
        MinecraftForge.EVENT_BUS.register(new KeyHandler());
        MinecraftForge.EVENT_BUS.register(new OverlayHandler());
        MinecraftForge.EVENT_BUS.register(new RingHandler());

    }

    public void init(FMLInitializationEvent e) {

        GameRegistry.registerWorldGenerator(new WorldGenerator(),0);
        VanillaRecepies.init();
    }

    public void postInit(FMLPostInitializationEvent e) {

    }

}
