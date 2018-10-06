package com;

/**
 * @author 海想着你
 * @create 2018-09-30 15:24
 */


import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 测试线程数
 */
public class JMXDemo {

    public static void main(String[] args) {
        //获取java线程管理MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //不需要获取同步的monitor和synchronized,仅获取线程堆栈信息
        ThreadInfo[] infos = threadMXBean.dumpAllThreads(false,false);
        //遍历
        for (ThreadInfo info : infos) {
            System.out.println(info.getThreadName());
        }
    }
}
