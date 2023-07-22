package org.example.lock.deadlock;

/**
 * @auther wendongchao
 * @date 2023/6/29 16:56
 **/
public class Consumer implements Runnable {
    private Person person;

    public Consumer(Person person) {
        this.person = person;
    }
    @Override
    public void run() {
        while (true) {
            person.getPerson();
        }
    }
}
