package com.pefier.MyFirstMod;

import com.pefier.MyFirstMod.handler.ConfigurationHandler;
import com.pefier.MyFirstMod.init.ModEntitys;
import com.pefier.MyFirstMod.init.ModItems;
import com.pefier.MyFirstMod.item.ItemBambus;
import com.pefier.MyFirstMod.proxy.ClientProxy;
import com.pefier.MyFirstMod.proxy.IProxy;
import com.pefier.MyFirstMod.reference.Reference;
import com.pefier.MyFirstMod.utility.LogHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by New Profile on 05.03.2016.
 */
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME,version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class MyFirstMod {

    @Mod.Instance(Reference.MOD_ID)
    public static MyFirstMod instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS , serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;
    public static ClientProxy clientProxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e){

        ConfigurationHandler.init(e.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
        ModItems.preinit();
        ModEntitys.init();


    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent e){



        if(e.getSide() == Side.CLIENT ) {
            ModItems.init();
        }
        clientProxy.register_renderers();
    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e){


    }

}
