package org.example.reflection;

import java.beans.Transient;

/**
 * 反射类
 *
 * @auther wendongchao
 * @date 2023/6/13 20:00
 **/
public class SmallPineapple extends Pineapple {
    public String name;
    public int age;
    private double weight; // 体重只有自己知道

    public SmallPineapple() {
        super();
    }

    public SmallPineapple(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    @Transient
    @Override
    public void getInfo() {
        System.out.print("[" + name + " 的年龄是：" + age + "]");
    }

}
