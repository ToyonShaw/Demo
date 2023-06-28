package com.toyonshaw.demotest.springtest;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author Toyon Shaw
 * @date 2021/11/3
 */
@Component
public class AsyncService {

    public void async1() {
        System.out.println("1:" + Thread.currentThread().getName());
        //Todo 使用this调用，结果却是主线程，原调用线程一致。这说明@Async在this调用时没有生效。
        this.async2();
    }

    @Async
    public void async2() {
        System.out.println("2:" + Thread.currentThread().getName());
    }


}
