package org.example.reflection;

/**
 * @auther wendongchao
 * @date 2023/6/13 21:17
 **/
public abstract class Pineapple {

    public abstract void getInfo();

    public String address;
    private String ip;
    public Pineapple() {
    }

    public Pineapple(String address, String ip) {
        this.address = address;
        this.ip = ip;
    }

    public void getMessage(String message) {
        System.out.println("public:" + message);
    }



}
