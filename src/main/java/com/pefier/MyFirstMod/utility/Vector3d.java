package com.pefier.MyFirstMod.utility;

import net.minecraft.entity.Entity;

/**
 * Created by New Profile on 21.04.2016.
 */
public class Vector3d {


    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    private double x;
    private double y;
    private double z;

    public  Vector3d(double x,double y, double z){
        this.x=x;
        this.y=y;
        this.z=z;
    }
    public Vector3d(Entity entity){
        this.x= entity.posX;
        this.y=entity.posY;
        this.z=entity.posZ;

    }
    public Vector3d(Vector3d v){
        this.x=v.getX();
        this.y=v.getY();
        this.z=v.getZ();

    }


    public Vector3d add(Vector3d vec){
        this.x+=vec.getX();
        this.y+=vec.getY();
        this.z+=vec.getZ();

        return this;
    }
    public Vector3d copy(){

        return new Vector3d(this);
    }

    public Vector3d scale(double a){
        this.x*=a;
        this.y*=a;
        this.z*=a;

        return this;
    }
    public double mag() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public Vector3d normalize() {
        double d = Math.abs(mag());
        if (d != 0) {
            scale(1 / d);
        }
        return this;
    }

    private void multiply(double v) {




    }

    public Vector3d rotate(Vector3d axis,double angle) {
        angle *=0.5D;
        double a = Math.sin(angle);

        MyQuat.aroundAxis(axis.copy().normalize(), angle).rotate(this);
        return this;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }





}
