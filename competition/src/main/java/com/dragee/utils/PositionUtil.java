package com.dragee.utils;

/**
 * 位置工具类
 *
 * @author tys on 2021/4/8
 */
public class PositionUtil {

    private static final double EARTH_RADIUS = 6371000;

    public static double getDistance(Double lng1, Double lat1, Double lng2, Double lat2) {
        double radiansAX = Math.toRadians(lng1); // A经弧度
        double radiansAY = Math.toRadians(lat1); // A纬弧度
        double radiansBX = Math.toRadians(lng2); // B经弧度
        double radiansBY = Math.toRadians(lat2); // B纬弧度
        double cos = Math.cos(radiansAY) * Math.cos(radiansBY) * Math.cos(radiansAX - radiansBX)
                + Math.sin(radiansAY) * Math.sin(radiansBY);
        double acos = Math.acos(cos); // 反余弦值
        return EARTH_RADIUS * acos; // 最终结果
    }

    public static double getDistance(String lng1, String lat1, String lng2, String lat2) {
        double radiansAX = Math.toRadians(Double.parseDouble(lng1)); // A经弧度
        double radiansAY = Math.toRadians(Double.parseDouble(lat1)); // A纬弧度
        double radiansBX = Math.toRadians(Double.parseDouble(lng2)); // B经弧度
        double radiansBY = Math.toRadians(Double.parseDouble(lat2)); // B纬弧度
        double cos = Math.cos(radiansAY) * Math.cos(radiansBY) * Math.cos(radiansAX - radiansBX)
                + Math.sin(radiansAY) * Math.sin(radiansBY);
        double acos = Math.acos(cos); // 反余弦值
        return EARTH_RADIUS * acos; // 最终结果
    }

    public static void main(String[] args) {
        double distance = getDistance(120.278413011111, 36.2702262083333, 120.278522202778, 36.270209925);
        System.out.println(distance);


        int i=1;

        int j=i++;

        if((j>++j)&&(i++==j)){j+=i;}

        System.out.println(j);

    }
}
