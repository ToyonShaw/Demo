package com.toyonshaw.test.designmode.singleton;

/**
 * 静态内部类的实现
 * 当 Singleton 类加载时，静态内部类 SingletonHolder 没有被加载进内存。
 * 只有当调用 getUniqueInstance() 方法从而触发 SingletonHolder.INSTANCE 时 SingletonHolder 才会被加载，
 * 此时初始化 INSTANCE 实例。 这种方式不仅具有延迟初始化的好处，而且由虚拟机提供了对线程安全的支持。
 *
 * @author toyon
 * @since 2022/6/15
 */
public class StaticInner {

    private StaticInner() {

    }

    private static class InnerObject {
        private static StaticInner STATICINNER = new StaticInner();
    }

    private static StaticInner getInstance() {
        return InnerObject.STATICINNER;
    }

}
