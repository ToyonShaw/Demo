package com.toyonshaw.test.designmode.daofactory.simple;

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
        Car lexus = new Lexus();
        Car benz = new Benz();
        Car bmw = new BMW();

        logger.info("\nLexus: {}\n Benz: {}\n BMW: {} ",
                lexus.getSimpleIntroduce(),benz.getSimpleIntroduce(),bmw.getSimpleIntroduce());

        logger.info("---------------------");

        Car lexus2 = CarFactory.getCar("Lexus");
        Car benz2 = CarFactory.getCar("Benz");
        Car bmw2 = CarFactory.getCar("BMW");

        logger.info("\nLexus: {}\n Benz: {}\n BMW: {} ",
                lexus2.getSimpleIntroduce(),benz2.getSimpleIntroduce(),bmw2.getSimpleIntroduce());
    }

}
