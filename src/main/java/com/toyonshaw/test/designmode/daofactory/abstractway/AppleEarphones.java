package com.toyonshaw.test.designmode.daofactory.abstractway;

/**
 * @Description 苹果耳机
 * @Auther Toyon Shaw
 * @Date 2021/8/6
 */
public class AppleEarphones implements IEarphones {
    @Override
    public void name() {
        System.out.println("Airpods Pro");
    }

    @Override
    public void price() {
        System.out.println("价格：1999￥");
    }
}
