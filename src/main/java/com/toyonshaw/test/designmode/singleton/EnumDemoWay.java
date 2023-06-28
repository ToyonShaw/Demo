package com.toyonshaw.test.designmode.singleton;

/**
 * @author toyon
 * @since 2022/6/15
 */
public class EnumDemoWay {

    private EnumDemoWay() {

    }

    private enum UniqueInstance {
        /**
         *
         */
        INSTANCE{
            @Override
            public void doSomething() {

            }
        };

        public abstract void doSomething();

    }


}
