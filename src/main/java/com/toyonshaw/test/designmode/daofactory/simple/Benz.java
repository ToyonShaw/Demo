package com.toyonshaw.test.designmode.daofactory.simple;

/**
 * @Description
 * @Auther Toyon Shaw
 * @Date 2021/8/6
 */
public class Benz implements Car{
    @Override
    public String getCarBrand() {
        return "汽车品牌：奔驰";
    }

    @Override
    public String getCarModal() {
        return "型号：AMG cls63";
    }

    @Override
    public String getCarPrice() {
        return "裸车价格：230W。";
    }

    @Override
    public String getSimpleIntroduce() {
        return getCarBrand()+getCarBrand()+getCarPrice();
    }
}
