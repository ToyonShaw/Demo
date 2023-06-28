package com.toyonshaw.test.designmode.flyweight;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author toyon
 * @since 2022/9/23
 */
public class FlyWeightFactory {
    private static ConcurrentHashMap<String,Circle> circleCacheMap = new ConcurrentHashMap<>();

    public static Circle getCircleByColor(String color) {
        if (!circleCacheMap.containsKey(color)) {
            int x = (int)(Math.random()*100 );
            int y = (int)(Math.random()*100 );;
            int radius = (int)(Math.random()*100 );
            Circle circle = new Circle(color,x,y,radius);
            circleCacheMap.put(color, circle);
        }
        return circleCacheMap.get(color);
    }


}
