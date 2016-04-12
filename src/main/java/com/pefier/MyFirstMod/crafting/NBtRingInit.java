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




    public static ItemStack  calcNBT(List<ItemStack> inputList, ItemStack output){
        int maxcharge=12000;
        int rechargerate=10;

        int dmgreduction=0;
        int dmgIncrease=0;

        int minigSpeed=0;
        int jumphight=0;



        for (int i = 0; i<inputList.size();i++){
            if(inputList.get(i).getItem() == ModItems.powerCristallUnlocked){
                //redgem
                if(inputList.get(i).getMetadata() == 0){

                    dmgIncrease+=1;

                //Blue
                }else if(inputList.get(i).getMetadata() == 1){

                    maxcharge+=600;

                    //Green
                }else if(inputList.get(i).getMetadata() == 2){

                    dmgreduction += 10;

                //Yellow
                }else if(inputList.get(i).getMetadata() == 3){

                    maxcharge-=300;
                    rechargerate+=1;
                    minigSpeed+=1;

                }
            }
        }
        ItemStack stack = output;
        if(!output.hasTagCompound()){
            NBTTagCompound data = new NBTTagCompound();
            data.setBoolean(Name.NBTKey.TAG_STATUS,true);
            data.setInteger(Name.NBTKey.TAG_CHARGE,0);
            data.setInteger(Name.NBTKey.TAG_MAX_CHARGE,maxcharge);
            data.setInteger(Name.NBTKey.TAG_RECHARGERATE,rechargerate);
            data.setInteger(Name.NBTKey.TAG_DMGINCREASE,dmgIncrease);
            data.setInteger(Name.NBTKey.TAG_DMGREDUKTION,dmgreduction);
            data.setInteger(Name.NBTKey.TAG_MININGSPEED,minigSpeed);
            data.setInteger(Name.NBTKey.TAG_JUMPHIGHT,jumphight);
            stack.setTagInfo(Name.NBTKey.TAG_RINGDATA,data);


        }

        return stack;
    }



   /* private ItemStack initNBTonRing(ItemStack stack){
        ItemStack stack1 = stack;
        if(!stack1.hasTagCompound()){
            NBTTagCompound data = new NBTTagCompound();
            data.setBoolean(Name.NBTKey.TAG_STATUS,true);
            data.setInteger(Name.NBTKey.TAG_CHARGE,0);
            data.setInteger(Name.NBTKey.TAG_MAX_CHARGE,maxcharge);
            data.setInteger(Name.NBTKey.TAG_RECHARGERATE,rechargerate);
            data.setInteger(Name.NBTKey.TAG_DMGINCREASE,dmgIncrease);
            data.setInteger(Name.NBTKey.TAG_DMGREDUKTION,dmgreduction);
            data.setInteger(Name.NBTKey.TAG_MININGSPEED,minigSpeed);
            data.setInteger(Name.NBTKey.TAG_JUMPHIGHT,jumphight);
            stack1.setTagInfo(Name.NBTKey.TAG_RINGDATA,data);
        }

        return stack1;
    }
    */

}
