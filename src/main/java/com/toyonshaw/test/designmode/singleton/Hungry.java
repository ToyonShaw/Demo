package com.toyonshaw.test.designmode.singleton;

/**
 * 饿汉模式-线程安全
 *
 * @author toyon
 * @since 2022/6/15
 */
public class Hungry {

    private static Hungry HUNGRY = new Hungry();

    private Hungry() {

    }

    public static Hungry getInstance() {
        return HUNGRY;
    }

}
