package com.toyonshaw.test.designmode.daofactory.method;

/**
 * @Description
 * @Auther Toyon Shaw
 * @Date 2021/8/6
 */
public class Bmw implements Car {
    @Override
    public String getCarBrand() {
        return "汽车品牌：宝马；";
    }

    @Override
    public String getCarModal() {
        return "型号：M5雷霆；";
    }

    @Override
    public String getCarPrice() {
        return "裸车价格：180W。";
    }

    @Override
    public String getSimpleIntroduce() {
        return getCarBrand()+getCarBrand()+getCarPrice();
    }
}
