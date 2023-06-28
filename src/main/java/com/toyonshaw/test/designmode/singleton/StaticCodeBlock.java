package com.toyonshaw.test.designmode.singleton;

/**
 * 静态代码块 单例
 *
 * @author toyon
 * @since 2022/10/31
 */
public class StaticCodeBlock {

    private static StaticCodeBlock obj;

    static {
        obj = new StaticCodeBlock();
    }

    private StaticCodeBlock() {

    }

    public static StaticCodeBlock getInstance() {
        return obj;
    }


}
