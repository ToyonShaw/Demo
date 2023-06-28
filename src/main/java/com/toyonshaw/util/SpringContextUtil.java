package com.toyonshaw.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * spring应用容器工具类
 *
 * @author toyon
 * @since 2022/9/23
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

    /**
     * Spring应用上下文环境
     */
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    /**
     * 通过bean的名称获取bean
     *
     * @param name bean名称
     * @return Object
     */
    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }

    /**
     * 根据类获取beam
     *
     * @param classType 类
     * @param <T>       泛型类
     * @return T
     */
    public static <T> T getBean(Class<T> classType) {
        return applicationContext.getBean(classType);
    }

    /**
     * 根据bean名称和类获取bean
     *
     * @param name      bean名称
     * @param classType 类
     * @param <T>       泛型类
     * @return T
     */
    public static <T> T getBean(String name, Class<T> classType) {
        return applicationContext.getBean(name, classType);
    }

}
