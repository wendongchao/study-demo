package org.example.lock.deadlock;

import org.example.lock.CommonLock;

/**
 * 死锁
 *
 * @auther wendongchao
 * @date 2023/6/29 16:33
 **/
public class DeadLockDemo01 implements Runnable {
    private boolean flag;

    public DeadLockDemo01(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            while (true) {
                synchronized (CommonLock.obj1) {
                    System.out.println(Thread.currentThread().getName() + "....if...obj1...");
                    synchronized (CommonLock.obj2) {
                        System.out.println(Thread.currentThread().getName() + ".....if.....obj2.....");
                    }
                }
            }
        } else {
            while (true) {
                synchronized (CommonLock.obj2) {
                    System.out.println(Thread.currentThread().getName() + "....else...obj2...");
                    synchronized (CommonLock.obj1) {
                        System.out.println(Thread.currentThread().getName() + ".....else.....obj1.....");
                    }
                }
            }
        }
    }
}
