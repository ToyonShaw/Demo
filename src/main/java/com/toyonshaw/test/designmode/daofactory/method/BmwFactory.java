package com.toyonshaw.test.designmode.daofactory.method;

/**
 * @Description
 * @Auther Toyon Shaw
 * @Date 2021/8/6
 */
public class BmwFactory implements CarFactory{
    @Override
    public Car getCar() {
        return new Bmw();
    }
}
