package com.toyonshaw.test.reflect;

import com.alibaba.fastjson.JSONObject;
import com.toyonshaw.test.designmode.decorator.Milk;
import lombok.extern.slf4j.Slf4j;

/**
 * @author toyon
 * @date 2022/4/1
 */
@Slf4j
public class Demo {

    public static void main(String[] args) {
        Milk milk = (Milk) BeanFactory.getObjectByName("com.toyonshaw.test.decorator.Milk");

        Milk milk2 = (Milk) BeanFactory.getObjectByConstructor("com.toyonshaw.test.decorator.Milk");

        log.info("milk: {}", JSONObject.toJSONString(milk2));
    }

}
