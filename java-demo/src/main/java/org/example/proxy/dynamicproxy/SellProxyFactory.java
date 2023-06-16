package org.example.proxy.dynamicproxy;


import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * 动态代理
 * 代理工厂
 * @auther wendongchao
 * @date 2023/6/16 18:14
 **/
public class SellProxyFactory implements InvocationHandler {
    /** 代理的真实对象 */
    private Object realObject;

    public SellProxyFactory(Object realObject) {
        this.realObject = realObject;
    }

    private void doSomethingAfter() {
        System.out.println("执行代理后的额外操作...");
    }

    private void doSomethingBefore() {
        System.out.println("执行代理前的额外操作...");
    }

    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        doSomethingBefore();
        Object obj = method.invoke(realObject, args);
        doSomethingAfter();
        return obj;
    }
}
