package com.toyonshaw.test.designmode.decorator;

/**
 * 摩卡咖啡
 *
 * @author toyon
 * @date 2022/3/24
 */
public class Mocha extends CondimentDecorator{

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    private double myPrice() {
        return 2;
    }

    @Override
    public double cost() {
        return myPrice() + beverage.cost();
    }
}
