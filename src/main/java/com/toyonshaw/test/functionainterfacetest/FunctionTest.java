package com.toyonshaw.test.functionainterfacetest;

import lombok.extern.slf4j.Slf4j;

/**
 * @author toyon
 * @since 2022/12/25
 */
@Slf4j
public class FunctionTest {

    public static void main(String[] args) {
        //way1
        IConverter<String,Integer> converter1 = new IConverter<String, Integer>() {
            @Override
            public Integer convert(String form) {
                return Integer.parseInt(form);
            }
        };
        Integer result1 = converter1.convert("133");
        log.info("-----result1:{}------", result1);
        //way2
        IConverter<String,Integer> converter2 = p -> Integer.parseInt(p);
        //way3
        IConverter<String,Integer> converter3 = Integer::parseInt;
        IConverter<Integer,String> converter4 = String::valueOf;
        converter4.convert(111);

    }



    @FunctionalInterface
    interface IConverter<F, T> {
        /**
         * 转换
         *
         * @param form form
         * @return T
         */
        T convert(F form);


    }


}


