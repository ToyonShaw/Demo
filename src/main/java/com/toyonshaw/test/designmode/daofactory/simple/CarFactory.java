package com.toyonshaw.test.designmode.daofactory.simple;

import java.util.Objects;

/**
 * @Description 简单工厂模式
 * 静态工厂模式
 * 开闭原则
 * @Auther Toyon Shaw
 * @Date 2021/8/6
 */
public interface CarFactory {

    //方法一
    public static Car getCar(String carBrand) {
        if (Objects.equals(carBrand, "Lexus")) {
            return new Lexus();
        } else if (Objects.equals(carBrand, "Benz")) {
            return new Benz();
        } else if (Objects.equals(carBrand, "BMW")) {
            return new BMW();
        } else {
            System.out.println("参数有误！");
        }
        return null;
    }

    //方法二
    public static Car lexus(){
        return new Lexus();
    }

    public static Car Benz(){
        return new Benz();
    }

    public static Car bmw(){
        return new BMW();
    }


}
