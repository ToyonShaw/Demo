package com.toyonshaw.test.designmode.decorator;

/**
 * 黑咖啡
 * @author toyon
 * @date 2022/3/24
 */
public class DarkRoast implements Beverage{
    @Override
    public double cost() {
        return 1;
    }
}
