package com.toyonshaw.test.designmode.decorator;

/**
 * 客户端
 *
 * @author toyon
 * @date 2022/3/24
 */
public class Client {

    public static void main(String[] args) {
        Beverage beverage = new HouseBlend();
        beverage = new Mocha(beverage);
        beverage = new Milk(beverage);
        System.out.println(beverage.cost());
    }

}
