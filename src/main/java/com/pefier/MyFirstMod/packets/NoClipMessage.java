package com.pefier.MyFirstMod.packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * Created by New Profile on 18.03.2016.
 */

public class NoClipMessage implements IMessage {
    private boolean noClip;


        public NoClipMessage() { }
        public NoClipMessage(boolean noClip){

            this.noClip = noClip;
        }
        @Override
        public void fromBytes(ByteBuf buf) {
            noClip = buf.readBoolean();

    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeBoolean(noClip);

    }
    public static class Handler implements IMessageHandler<NoClipMessage, IMessage> {

        @Override
        public NoClipMessage onMessage(final NoClipMessage message, final MessageContext ctx) {
            IThreadListener mainThread = (WorldServer) ctx.getServerHandler().playerEntity.worldObj;
            mainThread.addScheduledTask(new Runnable() {
                @Override
                public void run() {
                    ctx.getServerHandler().playerEntity.noClip=message.noClip;
                   // System.out.println(String.format("Received noClip is : %n from %s", ctx.getServerHandler().playerEntity.noClip, ctx.getServerHandler().playerEntity.getDisplayName()));
                }
            });

            return null;



        }
        public void handler(NoClipMessage message, MessageContext ctx){


        }
    }
}
