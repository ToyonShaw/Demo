package com.toyonshaw.test.designmode.daofactory.abstractway;

/**
 * @Description 苹果手机
 * @Auther Toyon Shaw
 * @Date 2021/8/6
 */
public class AppleMobilePhone implements IMobilePhone{


    @Override
    public void name() {
        System.out.println("iphone12Pro 256G");
    }

    @Override
    public void price() {
        System.out.println("价格：9299￥");
    }
}
