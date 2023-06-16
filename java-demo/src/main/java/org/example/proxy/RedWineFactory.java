package org.example.proxy;

/**
 * 真实对象
 * 红酒供应商
 * @auther wendongchao
 * @date 2023/6/16 18:24
 **/
public class RedWineFactory implements SellWine {

    @Override
    public void sellWine(double price) {
        System.out.println("成功售卖一瓶红酒，价格：" + price + "元");
    }

}
