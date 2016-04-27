package com.pefier.MyFirstMod;

import com.pefier.MyFirstMod.client.gui.GuiHandler;
import com.pefier.MyFirstMod.handler.ConfigurationHandler;
import com.pefier.MyFirstMod.init.ModEntitys;
import com.pefier.MyFirstMod.packets.NoClipMessage;
import com.pefier.MyFirstMod.proxy.CommonProxy;
import com.pefier.MyFirstMod.reference.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import org.lwjgl.Sys;

import java.util.UUID;

/**
 * Created by New Profile on 05.03.2016.
 */
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME,version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class MyFirstMod {

    @Mod.Instance(Reference.MOD_ID)
    public static MyFirstMod instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS , serverSide = Reference.SERVER_PROXY_CLASS)

    public static CommonProxy proxy;

    public static SimpleNetworkWrapper network;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e){
        //System.out.println(UUID.randomUUID());
        proxy.preInit(e);
        ConfigurationHandler.init(e.getSuggestedConfigurationFile());
        ModEntitys.init();

        NetworkRegistry.INSTANCE.registerGuiHandler(instance,new GuiHandler());

        network = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);
        network.registerMessage(NoClipMessage.Handler.class,NoClipMessage.class,0,Side.SERVER);





    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent e){
        proxy.init(e);

    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e){
        proxy.postInit(e);

    }

}
