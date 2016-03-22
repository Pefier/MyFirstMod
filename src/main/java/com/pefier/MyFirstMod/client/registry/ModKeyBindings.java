package com.pefier.MyFirstMod.client.registry;

import com.pefier.MyFirstMod.client.settings.Keybindings;
import net.minecraftforge.fml.client.registry.ClientRegistry;

/**
 * Created by New Profile on 18.03.2016.
 */
public class ModKeyBindings {

    public static void RegisterKeyBindings(){
        ClientRegistry.registerKeyBinding(Keybindings.aktivate);
    }


}
