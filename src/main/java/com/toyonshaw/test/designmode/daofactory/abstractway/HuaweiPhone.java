package com.toyonshaw.test.designmode.daofactory.abstractway;

/**
 * @Description 华为手机
 * @Auther Toyon Shaw
 * @Date 2021/8/6
 */
public class HuaweiPhone implements IMobilePhone{
    @Override
    public void name() {
        System.out.println("华为P50 Pro");
    }

    @Override
    public void price() {
        System.out.println("价格：7088￥");
    }
}
