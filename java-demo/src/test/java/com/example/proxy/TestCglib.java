package com.example.proxy;

import junit.framework.TestCase;
import org.example.proxy.cglib.SellPerfumeFactory;
import org.example.proxy.cglib.SellProxyFactory;

/**
 * @auther wendongchao
 * @date 2023/6/16 22:33
 **/
public class TestCglib extends TestCase {

    public void test01() {
        SellProxyFactory sellProxyFactory = new SellProxyFactory();
        // 获取一个代理实例
        SellPerfumeFactory proxyInstance =
                (SellPerfumeFactory) sellProxyFactory.getProxyInstance(new SellPerfumeFactory());
        // 创建代理类
        proxyInstance.sellPerfume(1999.99);
    }
}
