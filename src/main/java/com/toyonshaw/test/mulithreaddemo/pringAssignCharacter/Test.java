package com.toyonshaw.test.mulithreaddemo.pringAssignCharacter;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目： <br>
 * A线程打印A <br>
 * B线程打印B <br>
 * C线程打印C  <br>
 * <br>
 * 交替打印ABCABC......打印100个字符
 *
 * @author toyon
 * @since 2022/8/20
 */
public class Test {

    private static AtomicInteger count = new AtomicInteger(0);

    private static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        Condition conditionA = reentrantLock.newCondition();
        Condition conditionB = reentrantLock.newCondition();
        Condition conditionC = reentrantLock.newCondition();

        Thread t1 = new Thread(new PrintCharacter(reentrantLock, conditionA, conditionB, 34, 'A'));
        Thread t2 = new Thread(new PrintCharacter(reentrantLock, conditionB, conditionC, 33, 'B'));
        Thread t3 = new Thread(new PrintCharacter(reentrantLock, conditionC, conditionA, 33, 'C'));

        t1.start();
        t2.start();
        t3.start();

    }


    static class PrintCharacter implements Runnable {

        private int index = 0;

        private ReentrantLock reentrantLock;
        private Condition currentCondition;

        private Condition nextCondition;

        private int printTimes;

        private Character character;

        public PrintCharacter(ReentrantLock reentrantLock, Condition currentCondition, Condition nextCondition, int printTimes, Character character) {
            this.reentrantLock = reentrantLock;
            this.currentCondition = currentCondition;
            this.nextCondition = nextCondition;
            this.printTimes = printTimes;
            this.character = character;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    reentrantLock.lock();
                    if (index <= printTimes) {
                        System.out.print(character);
                        index++;
                    }
                    nextCondition.signal();

                    currentCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                reentrantLock.unlock();
            }
        }
    }


}
