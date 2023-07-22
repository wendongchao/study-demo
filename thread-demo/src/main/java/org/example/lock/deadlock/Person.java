package org.example.lock.deadlock;

/**
 * @auther wendongchao
 * @date 2023/6/29 16:53
 **/
public class Person {
    private String name;
    private String age;
    private boolean redux = false;
    private boolean flag = true;

    public synchronized void setPerson() {
        while (redux) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (flag) {
            flag = false;
            this.name = "李白";
            this.age = "23";
        } else {
            flag = true;
            this.name = "杜甫";
            this.age = "22";
        }
        redux = true;
		this.notifyAll();//唤醒所有
//        this.notify();//用于wait()的唤醒，唤醒一个，唤醒之后需要重新争抢锁，等待的时候已经放弃锁了
    }

    public synchronized void getPerson() {
        while (!redux) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + "---------------" + age);
        redux = false;
		this.notifyAll();//唤醒所有
//        this.notify();//用于wait()的唤醒，唤醒一个，唤醒之后需要重新争抢锁，等待的时候已经放弃锁了
    }
}
