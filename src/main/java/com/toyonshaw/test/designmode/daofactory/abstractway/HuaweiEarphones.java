package com.toyonshaw.test.designmode.daofactory.abstractway;

/**
 * @Description 华为耳机
 * @Auther Toyon Shaw
 * @Date 2021/8/6
 */
public class HuaweiEarphones implements IEarphones {
    @Override
    public void name() {
        System.out.println("FreeBuds Pro");
    }

    @Override
    public void price() {
        System.out.println("价格：999￥");
    }
}
