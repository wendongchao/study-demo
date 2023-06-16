package org.example.proxy.cglib;

/**
 * 真实对象
 * @auther wendongchao
 * @date 2023/6/16 22:35
 **/
public class SellPerfumeFactory {
    public void sellPerfume(double price) {
        System.out.println("成功购买香奈儿品牌的香水，价格是：" + price + "元");
    }

}
