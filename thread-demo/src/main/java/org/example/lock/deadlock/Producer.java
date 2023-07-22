package org.example.lock.deadlock;

/**
 * 生产者
 * @auther wendongchao
 * @date 2023/6/29 16:54
 **/
public class Producer implements Runnable {
    private Person person;

    public Producer(Person person) {
        this.person = person;
    }
    @Override
    public void run() {
        while (true) {
            person.setPerson();
        }
    }
}
