package com.toyonshaw.test.designmode.flyweight;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author toyon
 * @since 2022/9/23
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Circle implements Shape {
    /**
     * 颜色
     */
    private String color;

    /**
     *  X轴位置
     */
    private int x;
    /**
     * Y轴位置
     */
    private int y;

    /**
     * 圆的半径
     */
    private int radius;

    public Circle(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        log.info("Circle Draw() ——————  color: {},  x:{},  y:{},  radius:{},  object address:{}", color, x, y, radius, this);
    }
}
