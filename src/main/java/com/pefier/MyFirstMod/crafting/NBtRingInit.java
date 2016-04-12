package com.pefier.MyFirstMod.crafting;

import com.pefier.MyFirstMod.init.ModItems;
import com.pefier.MyFirstMod.reference.Name;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.List;

/**
 * Created by New Profile on 11.04.2016.
 */
public class NBtRingInit {
    private int maxcharge;
    private int rechargerate;

    private int dmgreduction;
    private int dmgIncrease;

    private int minigSpeed;
    private int jumphight;

    public NBtRingInit(){
        maxcharge=0;
        rechargerate=0;
        dmgreduction=0;
        dmgIncrease=0;
        minigSpeed=0;
        jumphight=0;




    }

    public ItemStack calcNBT(List<ItemStack> inputList, ItemStack output){




        for (int i = 0; i<inputList.size();i++){
            if(inputList.get(i).getItem() == ModItems.powerCristallUnlocked){
                //redgem
                if(inputList.get(i).getMetadata() == 0){
                dmgIncrease+=1;


                //Blue
                }else if(inputList.get(i).getMetadata() == 1){
                    maxcharge+=1;



                    //Green
                }else if(inputList.get(i).getMetadata() == 2){

                    dmgreduction += 10;


                //Yellow
                }else if(inputList.get(i).getMetadata() == 3){
                    maxcharge-=1;
                    rechargerate+=1;
                    minigSpeed+=1;

                }


            }



        }










        return output;
    }



    public static ItemStack initNBTonRing(ItemStack stack, int maxcharge){
        ItemStack stack1 = stack;

        if(!stack1.hasTagCompound()){
            NBTTagCompound data = new NBTTagCompound();
            data.setBoolean(Name.NBTKey.TAG_STATUS,true);
            data.setInteger(Name.NBTKey.TAG_CHARGE,0);
            data.setInteger(Name.NBTKey.TAG_MAX_CHARGE,maxcharge);
            stack.setTagInfo(Name.NBTKey.TAG_RINGDATA,data);


        }


        return stack1;
    }


}
