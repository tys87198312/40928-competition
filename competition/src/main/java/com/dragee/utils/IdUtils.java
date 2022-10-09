package com.dragee.utils;

import java.util.Random;

/**
 * @author tys on 2021/5/13
 */
public class IdUtils {

    private static Random random = new Random();

    /**
     * 生成Long 类型唯一ID
     */
    public synchronized static Long getId() {
        if (random == null) {
            random = new Random();
        }
        Long id = Long.valueOf(System.currentTimeMillis() + "" + random.nextInt(99));
        return id;
    }

    public static void main(String[] args) {
        Long id = getId();
        System.out.println(id);
    }
}
