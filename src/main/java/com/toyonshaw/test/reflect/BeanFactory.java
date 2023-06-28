package com.toyonshaw.test.reflect;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 *  反射机制
 *
 * @author Toyon Shaw
 * @date 2021/8/6
 */
@Slf4j
public class BeanFactory {
    private static Object object = null;

    /**
     * newInstance方法
     *
     * @param name name
     * @return Object
     */
    public static Object getObjectByName(String name) {
        try {
            Class<?> c = Class.forName(name);
            object = c.newInstance();
        } catch (Exception e) {
            String error = StrUtil.format("反射异常, name={}", name);
            log.error(error, e);
        }
        return object;
    }

    /**
     * newInstance方法
     *
     * @param name name
     * @return Object
     */
    public static Object getObjectByConstructor(String name) {
        try {
            Class<?> c = Class.forName(name);
            Constructor<?> constructor = c.getConstructor();
            object = constructor.newInstance();
        } catch (Exception e) {
            String error = StrUtil.format("反射异常, name={}", name);
            log.error(error, e);
        }
        return object;
    }


    public static Object createWorker4(String objectPath) {
        ObjectInput input = null;
        try {
            input = new ObjectInputStream(new FileInputStream(objectPath));
            object = input.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }

}
