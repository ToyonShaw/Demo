package com.toyonshaw.test.demo1;

import lombok.extern.slf4j.Slf4j;

/**
 * <pre>
 *     1.8接口新增默认实现方法
 * </pre>
 *
 * @author toyon
 * @since 2022/12/25
 */
public interface InterfaceTest {
    /**
     * 计算
     *
     * @param a a
     * @return double
     */
    double calculate(int a);

    /**
     * 平方
     *
     * @param a a
     * @return double
     */
    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}

@Slf4j
class InterfaceTestMain {

    public static void main(String[] args) {
        InterfaceTest test = new InterfaceTest() {
            @Override
            public double calculate(int a) {
                return a;
            }
        };
        log.info("-----calculate:{}-----", test.calculate(133));
        log.info("-----sqrt:{}-----", test.sqrt(52133));

        InterfaceTest test2 = p -> p * p;

    }




}