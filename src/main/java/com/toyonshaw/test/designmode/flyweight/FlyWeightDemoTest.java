package com.toyonshaw.test.designmode.flyweight;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author toyon
 * @since 2022/9/23
 */
public class FlyWeightDemoTest {

    /**
     * 颜色集合
     */
    public static List<String> ColorGroup = Arrays.asList("red","blue","yellow","white","black","pink","purple","green");

    /**
     * 限制循环最大次数
     */
    public static final int LIMIT = 100;
    private static volatile AtomicInteger count = new AtomicInteger(0);

    public static void main(String... args) {
        while (count.get() < LIMIT) {
            Circle circle = FlyWeightFactory.getCircleByColor(getRandomColor());
            circle.draw();
            count.getAndIncrement();
        }
    }

    private static String getRandomColor() {
        return ColorGroup.get((int)(Math.random()*ColorGroup.size()));
    }

}
