package org.example.pool;

/**
 * @auther wendongchao
 * @date 2023/6/30 15:21
 **/
public class MyTaskPool implements Runnable {
    private int taskNum;

    public MyTaskPool(int num) {
        this.taskNum = num;
    }

    @Override
    public void run() {
        System.out.println("正在执行task " + taskNum);
        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task " + taskNum + "执行完毕");
    }
}
