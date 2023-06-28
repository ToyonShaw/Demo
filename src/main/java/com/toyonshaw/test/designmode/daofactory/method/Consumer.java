package com.toyonshaw.test.designmode.daofactory.method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description
 * @Auther Toyon Shaw
 * @Date 2021/8/6
 */
public class Consumer {

    private static Logger logger = LoggerFactory.getLogger(Consumer.class);

    public static void main(String[] args) {
        Car lexus = new LexusFactory().getCar();
        Car benz = new BenzFactory().getCar();
        Car bmw = new BmwFactory().getCar();

        logger.info("\nLexus: {}\n Benz: {}\n BMW: {} ",
                lexus.getSimpleIntroduce(),benz.getSimpleIntroduce(),bmw.getSimpleIntroduce());


    }

}
