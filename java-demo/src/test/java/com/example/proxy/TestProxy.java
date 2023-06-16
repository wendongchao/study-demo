package com.example.proxy;

import junit.framework.TestCase;
import org.example.proxy.RedWineFactory;
import org.example.proxy.SellWine;
import org.example.proxy.dynamicproxy.SellProxyFactory;
import org.example.proxy.ChanelFactory;
import org.example.proxy.SellPerfume;
import org.example.proxy.staticproxy.XiaoHongSellProxy;
import org.springframework.cglib.proxy.Proxy;

/**
 * @auther wendongchao
 * @date 2023/6/16 11:20
 **/
public class TestProxy extends TestCase {

    /**
     * 静态代理
     */
    public void test01() {
        ChanelFactory factory = new ChanelFactory();
        XiaoHongSellProxy proxy = new XiaoHongSellProxy(factory);
        proxy.sellPerfume(1999.99);
    }

    /**
     * 动态代理
     */
    public void test02() {
        ChanelFactory chanelFactory = new ChanelFactory();
        SellProxyFactory sellProxyFactory = new SellProxyFactory(chanelFactory);
        SellPerfume sellPerfume = (SellPerfume) Proxy.newProxyInstance(
                chanelFactory.getClass().getClassLoader(),
                chanelFactory.getClass().getInterfaces(),
                sellProxyFactory);
        sellPerfume.sellPerfume(1999.99);
    }

    /**
     * 动态代理
     */
    public void test03() {
        // 实例化一个红酒销售商
        RedWineFactory redWineFactory = new RedWineFactory();
        // 实例化代理工厂，传入红酒销售商引用控制对其的访问
        SellProxyFactory sellProxyFactory = new SellProxyFactory(redWineFactory);
        // 实例化代理对象，该对象可以代理售卖红酒
        SellWine sellWineProxy = (SellWine) Proxy.newProxyInstance(
                redWineFactory.getClass().getClassLoader(),
                redWineFactory.getClass().getInterfaces(),
                sellProxyFactory);
        // 代理售卖红酒
        sellWineProxy.sellWine(1999.99);
    }

}
