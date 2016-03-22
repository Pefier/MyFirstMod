package com.pefier.MyFirstMod.packets;


import net.minecraft.util.IThreadListener;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * Created by New Profile on 18.03.2016.
 */
public class NoClipHandler implements IMessageHandler<NoClipMessage, IMessage> {

    @Override
    public NoClipMessage onMessage(NoClipMessage message, final MessageContext ctx) {
        IThreadListener mainThread = (WorldServer) ctx.getServerHandler().playerEntity.worldObj;
        mainThread.addScheduledTask(new Runnable() {
            @Override
            public void run() {
                ctx.getServerHandler().playerEntity.noClip=true;
            }
        });


        return null;
    }
}
