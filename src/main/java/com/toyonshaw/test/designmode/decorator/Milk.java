package com.toyonshaw.test.designmode.decorator;

/**
 * 牛奶
 *
 * @author toyon
 * @date 2022/3/24
 */
public class Milk extends CondimentDecorator{
    private String brand = "Nestle ";

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    public Milk() {
    }

    private double myPrice() {
        return 2;
    }

    @Override
    public double cost() {
        return myPrice() + beverage.cost();
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
