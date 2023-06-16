package org.example.proxy;


/**
 * 真实对象
 * 香水供应商
 * @auther wendongchao
 * @date 2023/6/16 11:01
 **/
public class ChanelFactory implements SellPerfume {
    @Override
    public void sellPerfume(double price) {
        System.out.println("成功购买香奈儿品牌的香水，价格是：" + price + "元");
    }
}
