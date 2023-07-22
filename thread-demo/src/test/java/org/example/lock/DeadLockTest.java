package org.example.lock;

import junit.framework.TestCase;
import org.example.lock.deadlock.Consumer;
import org.example.lock.deadlock.DeadLockDemo01;
import org.example.lock.deadlock.Person;
import org.example.lock.deadlock.Producer;

/**
 * 死锁
 * 死锁的四个条件：
 *      1、互斥条件：线程持有的资源排它性使用，在持有期间不能被其他线程持有。
 *      2、请求和保持条件：线程已经持有一个资源，允许继续申请其他资源，其他资源被另一线程持有，那么该线程进入阻塞等待。
 *      3、不剥夺条件：线程持有的资源，在未使用完之前不可被剥夺。
 *      4、循环等待：发生死锁时，必然存在一个线程对应的环形链。
 * 破坏死锁的四个条件之一，就可以解除死锁。
 * @auther wendongchao
 * @date 2023/6/29 16:25
 **/
public class DeadLockTest extends TestCase {

    /**
     * 多个锁之间的嵌套产生死锁
     * @author dongchao
     * @date 2023/6/29 18:07
     */
    public void test01() throws Exception {
        DeadLockDemo01 lockDemo01 = new DeadLockDemo01(true);
        DeadLockDemo01 lockDemo02 = new DeadLockDemo01(false);
        Thread t01 = new Thread(lockDemo01);
        Thread t02 = new Thread(lockDemo02);
        t01.start();
        t02.start();
    }

    /**
     * 多生产者与多消费者之间的死锁
     * @author dongchao
     * @date 2023/6/29 18:03
     */
    public void test02() throws Exception {
        Person person = new Person();
        Producer producer = new Producer(person);
        Consumer consumer = new Consumer(person);
        Thread t01 = new Thread(producer);
        Thread t02 = new Thread(producer);
        Thread t03 = new Thread(consumer);
        Thread t04 = new Thread(consumer);

        t01.start();
        t02.start();
        t03.start();
        t04.start();
    }
}
