package com.util;

import java.util.concurrent.TimeUnit;

/**
 * @author 海想着你
 * @create 2018-10-01 14:16
 */
public class SleepUtils {
    public static void second(long s) {
        try {
            TimeUnit.SECONDS.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
