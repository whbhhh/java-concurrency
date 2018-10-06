package com;

/**
 * @author 海想着你
 * @create 2018-09-30 20:41
 */

/**
 * 死锁
 */
public class DeadLockDemo {
    private static String A = "A";
    private static String B = "B";
    private void deadLock(){
        Thread t1 = new Thread(() -> {
            synchronized (A){
                try {
                    Thread.currentThread().sleep(2000);
                }catch (InterruptedException e){
                }
                synchronized (B){
                    System.out.println("1");
                }
            }

        });
        Thread t2 = new Thread(() -> {
            synchronized (B){
                try {
                    Thread.currentThread().sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (A){
                    System.out.println("2");
                }
            }
        });
        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }
}
