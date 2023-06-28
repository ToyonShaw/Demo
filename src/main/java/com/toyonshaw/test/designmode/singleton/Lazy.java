package com.toyonshaw.test.designmode.singleton;


/**
 * 懒汉模式(双重检查锁模式)-线程安全
 *
 * @author toyon
 * @since 2022/6/15
 */
public class Lazy {

    /**
     * 若不加volatile, 会造成线程安全问题。
     * 双重检查锁模式是一种非常好的单例实现模式，解决了单例、性能、线程安全问题，上面的双重检测锁模式看上去完美无缺，其实是存在问题，在多线程的情况下，
     * 可能会出现空指针问题，出现问题的原因是JVM在实例化对象的时候会进行优化和指令重排序操作。
     * 要解决双重检查锁模式带来空指针异常的问题，只需要使用volatile关键字，volatile关键字严格遵循happens-before原则，即在读操作前，写操作必须全部完成。
     */
    private static volatile Lazy lazy;

    private Lazy() {
    }

    public static Lazy getInstance() {
        if (null == lazy) {
            synchronized (Lazy.class) {
                if (null == lazy) {
                    lazy = new Lazy();
                }
            }
        }
        return lazy;
    }


}
