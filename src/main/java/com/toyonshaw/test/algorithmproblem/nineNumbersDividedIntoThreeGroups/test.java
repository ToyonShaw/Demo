package com.toyonshaw.test.algorithmproblem.nineNumbersDividedIntoThreeGroups;

import cn.hutool.core.lang.Assert;

/**
 * @author toyon
 * @date 2022/3/29
 */
public class test {

    /**
     * 数字的位数
     */
    public static final int NUMBER_COUNT = 3;

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            if (check(i)) {
                System.out.println(i);
            }
        }

    }

    public static boolean check( int n) {
        String a = n + "" + 2*n + 3*n;
        if (a.contains("1") &&  a.contains("2") &&  a.contains("3")
                &&  a.contains("4") &&  a.contains("5") &&  a.contains("6")
                &&  a.contains("7") &&  a.contains("8") &&  a.contains("9") ) {
            return true;
        }else {
            return false;
        }
    }

    /**
     * number为三位数
     *
     * @param number number
     * @return Integer
     */
    public static Integer getIndependentNumber(int number) {
        /*Integer sum;
        for (int i = NUMBER_COUNT; i > 0; i--) {

        }*/
        int hundred = number / 100 % 10;
        int ten = number / 10 % 10;
        int single = number % 10;
        return hundred + ten + single;
    }

    /**
     * 获取指定位数的最小值
     * Todo
     * @return int
     */
    public static int getNumberMin(int number) {
        Assert.isTrue(number > 0, "number必须为正整数");
        if (number==1) {
            return 0;
        }else {
            return 1;
        }

    }

}
