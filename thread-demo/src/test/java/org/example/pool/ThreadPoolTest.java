package org.example.pool;

import junit.framework.TestCase;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @auther wendongchao
 * @date 2023/6/30 15:22
 **/
public class ThreadPoolTest extends TestCase {

    public void test01() throws Exception {
        /*
        核心线程数：5
        最大线程数：10
        线程存活时间：200毫秒
        数组缓存队列：容量大小为5
        逻辑流程：线程数 < 核心线程数，
         */
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
        for (int i = 0; i < 15;i++) {
            MyTaskPool myTask = new MyTaskPool(i);
            executor.execute(myTask);
            System.out.println("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" +
                    executor.getQueue().size() + "，已执行玩别的任务数目：" + executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }
}
