package com.pefier.MyFirstMod.utility;

/**
 * Created by New Profile on 21.04.2016.
 */
public class MyQuat {
    public double x;
    public double y;
    public double z;
    public double s;
    public static final double SQRT2 = Math.sqrt(2D);

    public MyQuat() {
        s = 1.0D;
        x = 0.0D;
        y = 0.0D;
        z = 0.0D;
    }

    public MyQuat(MyQuat quat) {
        x = quat.x;
        y = quat.y;
        z = quat.z;
        s = quat.s;
    }

    public MyQuat(double d, double d1, double d2, double d3) {
        x = d1;
        y = d2;
        z = d3;
        s = d;
    }

    public static MyQuat aroundAxis(double ax, double ay, double az, double angle) {
        angle *= 0.5D;
        double d4 = Math.sin(angle);
        return new MyQuat(Math.cos(angle), ax * d4, ay * d4, az * d4);
    }
    public static MyQuat aroundAxis(Vector3d axis, double angle) {
        return aroundAxis(axis.getX(), axis.getY(), axis.getZ(), angle);
    }
    public void rotate(Vector3d vec) {
        double d = -x * vec.getX() - y * vec.getY() - z * vec.getZ();
        double d1 = s * vec.getX() + y * vec.getZ() - z * vec.getY();
        double d2 = s * vec.getY() - x * vec.getZ() + z * vec.getX();
        double d3 = s * vec.getZ() + x * vec.getY() - y * vec.getX();
        vec.setX(d1 * s - d * x - d2 * z + d3 * y);
        vec.setY(d2 * s - d * y + d1 * z - d3 * x);
        vec.setZ(d3 * s - d * z - d1 * y + d2 * x);
    }


}
