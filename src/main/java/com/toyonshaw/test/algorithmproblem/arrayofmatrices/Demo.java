package com.toyonshaw.test.algorithmproblem.arrayofmatrices;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

/**
 * @author toyon
 * @date 2022/4/1
 */
@Slf4j
public class Demo {

    public static void main(String[] args) {
        /*int[] numbers = new int[]{0, 1, 0, 3, 12, 58, 0, 99, 1234, 55555, 6666, 0, 7, 8, 0};
        dispose(numbers);
        log.info("result= {}", JSONObject.toJSONString(numbers));*/
        testStringBuilder();
    }

    private static void testStringBuilder() {
        StringBuilder sb = new StringBuilder();
        final int count = 26;
        for (int i = 0; i < count; i++) {
            sb.append((char) ('a' + i));
        }
        System.out.println(sb.toString());
    }


    private static void dispose(int[] numbers) {
        int temporary = 0;
        for (int num : numbers) {
            if (num != 0) {
                numbers[temporary++] = num;
            }
        }
        while (temporary < numbers.length) {
            numbers[temporary++] = 0;
        }
    }

}
