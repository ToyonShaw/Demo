package com.toyonshaw.test.designmode.daofactory.method;

/**
 * @Description
 * @Auther Toyon Shaw
 * @Date 2021/8/6
 */
public class Lexus implements Car {


    @Override
    public String getCarBrand() {
        return "汽车品牌：雷克萨斯；";
    }

    @Override
    public String getCarModal() {
        return "型号：LX570；";
    }

    @Override
    public String getCarPrice() {
        return "裸车价格：220W。";
    }

    @Override
    public String getSimpleIntroduce() {
        return getCarBrand()+getCarBrand()+getCarPrice();
    }

}
