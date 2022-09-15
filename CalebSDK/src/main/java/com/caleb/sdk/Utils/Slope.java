package com.caleb.sdk.Utils;

public class Slope {

    public Slope(){};

    public static double getSlope(double x1, double y1, double x2, double y2) {
        return (y2 - y1) / (x2 - x1);
    }

    public static double getYIntercept(double x1, double y1, double x2, double y2) {
        return y1 - (getSlope(x1, y1, x2, y2) * x1);
    }

    public static double getY(double x, double x1, double y1, double x2, double y2) {
        return (getSlope(x1, y1, x2, y2) * x) + getYIntercept(x1, y1, x2, y2);
    }

    public static double getX(double y, double x1, double y1, double x2, double y2) {
        return (y - getYIntercept(x1, y1, x2, y2)) / getSlope(x1, y1, x2, y2);
    }

    public static double getDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static double getDistance(double x1, double y1, double x2, double y2, double x3, double y3) {
        return Math.abs((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1)) / getDistance(x1, y1, x2, y2);
    }

    // 計算兩條斜線中間的空間
    public static double getSpace(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        double a = getDistance(x1, y1, x2, y2);
        double b = getDistance(x3, y3, x4, y4);
        double c = getDistance(x1, y1, x3, y3);
        double d = getDistance(x2, y2, x4, y4);
        double e = getDistance(x1, y1, x4, y4);
        double f = getDistance(x2, y2, x3, y3);
        double s = (a + b + c + d + e + f) / 2;
        return Math.sqrt((s - a) * (s - b) * (s - c) * (s - d) - a * b * c * d * Math.pow(Math.cos((e * e + f * f - a * a - b * b) / (2 * a * b)), 2));
    }

    // x1, y1, x2, y2 為第一條直線的兩個點
    // x3, y3, x4, y4 為第二條直線的兩個點
    // x5, y5 是否在兩條直線範圍
    public static boolean isBetween(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4, double x5, double y5) {
        double a = getDistance(x1, y1, x2, y2);
        double b = getDistance(x3, y3, x4, y4);
        double c = getDistance(x1, y1, x3, y3);
        double d = getDistance(x2, y2, x4, y4);
        double e = getDistance(x1, y1, x4, y4);
        double f = getDistance(x2, y2, x3, y3);
        double s = (a + b + c + d + e + f) / 2;
        double space = Math.sqrt((s - a) * (s - b) * (s - c) * (s - d) - a * b * c * d * Math.pow(Math.cos((e * e + f * f - a * a - b * b) / (2 * a * b)), 2));
        double space1 = getSpace(x1, y1, x2, y2, x3, y3, x5, y5);
        double space2 = getSpace(x1, y1, x2, y2, x5, y5, x4, y4);
        double space3 = getSpace(x3, y3, x4, y4, x1, y1, x5, y5);
        double space4 = getSpace(x3, y3, x4, y4, x5, y5, x2, y2);
        return space == space1 + space2 + space3 + space4;
    }






}
