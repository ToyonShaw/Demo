package com.toyonshaw.test.designmode.decorator;

/**
 * 星巴克咖啡
 * @author toyon
 * @date 2022/3/24
 */
public class HouseBlend implements Beverage{
    @Override
    public double cost() {
        return 10;
    }
}
