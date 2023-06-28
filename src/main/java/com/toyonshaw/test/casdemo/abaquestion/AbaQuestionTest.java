package com.toyonshaw.test.casdemo.abaquestion;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 带版本号的原子引用（解决ABA问题） <br>
 * AtomicStampedReference版本号原子引用： <br>
 * 案例：两种原子引用的对比 <br>
 *
 * @author toyon
 * @since 2022/10/23
 */
@Slf4j
public class AbaQuestionTest {
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100,1);

    public static void main(String[] args) {
        /**
         * 当执行campare and swap会出现失败的情况。
         * 例如，一个线程先读取共享内存数据值A，随后因某种原因，线程暂时挂起，
         * 同时另一个线程临时将共享内存数据值先改为B，随后又改回为A。随后挂起线程恢复，
         * 并通过CAS比较，最终比较结果将会无变化。这样会通过检查，这就是ABA问题。
         * 在CAS比较前会读取原始数据，随后进行原子CAS操作。这个间隙之间由于并发操作，最终可能会带来问题。
         */
        System.out.println("************以下是ABA问题的产生**************");
        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean cas3 = atomicReference.compareAndSet(100, 2019);
            log.info("------ cas操作结果：{},  当前 atomicReferenect: {} ------", cas3, atomicReference.get());

        },"t1").start();

        new Thread(()->{
            boolean cas1 = atomicReference.compareAndSet(100, 101);
            log.info("------ cas操作结果：{} ------", cas1);
            boolean cas2 = atomicReference.compareAndSet(101, 100);
            log.info("------ cas操作结果：{} ------", cas2);
        },"t2").start();






        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("************以下是ABA问题的解决**************");

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"  "+"   第一次版本号："+stamp);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            atomicStampedReference.compareAndSet(100, 101, atomicStampedReference.getStamp(), atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName() +"  "+"   第2次版本号："+atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName() +"  "+"   第3次版本号："+atomicStampedReference.getStamp());

        },"t3").start();

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() +"  "+"   第一次版本号："+stamp);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean result =  atomicStampedReference.compareAndSet(100, 2019, stamp, stamp+1);
            System.out.println(Thread.currentThread().getName()+ "  修改成功否："+result+"  当前最新实际版本号：" +atomicStampedReference.getStamp());
            System.out.println(Thread.currentThread().getName()+ "  当前实际最新值：" +atomicStampedReference.getReference());

        },"t4").start();
    }

}


