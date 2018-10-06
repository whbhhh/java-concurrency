package com;

/**
 * @author 海想着你
 * @create 2018-10-01 14:14
 */

import com.util.SleepUtils;

/**
 * 守护线程
 */
public class DaemonDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }

    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            try {
                SleepUtils.second(10);
            } finally {
                System.out.println("DaemonThread finally run.");
            }
        }
    }
}
