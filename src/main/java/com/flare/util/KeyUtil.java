package com.flare.util;

import java.util.Random;

/**
 * @ClassName KeyUtil
 * @Description TODO
 * @Author EyesSmile
 * @Date 2018/12/31
 * @Version 1.0
 */
public class KeyUtil {
    /**
     * 生成唯一的主键
     * 格式：时间+随机数
     *
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        // 两位随机数
//        Integer a= random.nextInt(90)+10;
        //六位随机数
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
