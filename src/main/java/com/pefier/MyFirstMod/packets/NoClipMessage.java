package com.pefier.MyFirstMod.packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * Created by New Profile on 18.03.2016.
 */
public class NoClipMessage implements IMessage {
    private boolean noClip;
   // public NoClipMessage(){
      //  this.noClip = noClip;
   // }
    @Override
    public void fromBytes(ByteBuf buf) {
        //noClip = buf.readBoolean();
    }

    @Override
    public void toBytes(ByteBuf buf) {
       // buf.writeBoolean(noClip);
    }
    public boolean getnoClip(){
        return this.noClip;
      }








    public static class Handler implements IMessageHandler<NoClipMessage, IMessage> {

        @Override
        public NoClipMessage onMessage(final NoClipMessage message, final MessageContext ctx) {
            IThreadListener mainThread = (WorldServer) ctx.getServerHandler().playerEntity.worldObj;
            mainThread.addScheduledTask(new Runnable() {
                @Override
                public void run() {
                    ctx.getServerHandler().playerEntity.noClip=true; //message.noClip;
                    //System.out.printf("name is %sand noclip is%n" , ctx.getServerHandler().playerEntity.getName(), message.noClip);

                }
            });


            return null;
        }
    }
}
