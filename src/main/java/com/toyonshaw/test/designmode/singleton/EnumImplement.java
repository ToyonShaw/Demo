package com.toyonshaw.test.designmode.singleton;

import java.io.Serializable;

/**
 * 单例模式-枚举实现
 * Todo 单例模式的最佳实践，它实现简单，并且在面对复杂的序列化或者反射攻击的时候，能够防止实例化多次。
 *
 * @author toyon
 * @since 2022/6/15
 */
public class EnumImplement implements Serializable {

    private EnumImplement() {

    }

    private enum UniqueInstance {
        /**
         *
         */
        INSTANCE;

        private final EnumImplement enumImplement;

        private UniqueInstance() {
            enumImplement = new EnumImplement();
        }

        private EnumImplement getInstance() {
            return enumImplement;
        }
    }

    public static EnumImplement getInstance() {
        return UniqueInstance.INSTANCE.getInstance();
    }

}
