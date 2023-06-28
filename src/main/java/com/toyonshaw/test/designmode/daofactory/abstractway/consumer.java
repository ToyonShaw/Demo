package com.toyonshaw.test.designmode.daofactory.abstractway;

/**
 * @Description
 * @Auther Toyon Shaw
 * @Date 2021/8/6
 */
public class consumer {

    public static void main(String[] args) {
        System.out.println("-----------苹果产品----------");
        AppleFactory appleFactory = new AppleFactory();
        IMobilePhone iphone = appleFactory.phone();
        IEarphones airpods = appleFactory.earphones();
        iphone.name();
        iphone.price();
        airpods.name();
        airpods.price();
        System.out.println("-----------华为产品产品----------");
        HuaweiFactory huaweiFactory = new HuaweiFactory();
        IMobilePhone p50Pro = huaweiFactory.phone();
        IEarphones freeBuds = huaweiFactory.earphones();
        p50Pro.name();
        p50Pro.price();
        freeBuds.name();
        freeBuds.price();
    }

}
