package com.pefier.MyFirstMod.client.gui;

import com.pefier.MyFirstMod.handler.ConfigurationHandler;
import com.pefier.MyFirstMod.reference.Reference;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

import javax.security.auth.login.Configuration;
import java.util.List;

/**
 * Created by New Profile on 06.03.2016.
 */
public class ModGuiConfig extends GuiConfig {
    public ModGuiConfig(GuiScreen guiScreen) {
        super(guiScreen,
                new ConfigElement(ConfigurationHandler.configuration.getCategory(net.minecraftforge.common.config.Configuration.CATEGORY_GENERAL)).getChildElements(),
                Reference.MOD_ID,
                "1",
                false,
                false,
                GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString()));
    }
}
