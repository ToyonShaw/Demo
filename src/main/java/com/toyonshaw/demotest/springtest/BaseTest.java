package com.toyonshaw.demotest.springtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *  //Todo 以@Async注解为例，@Async注解标记的方法，在执行时会被AOP处理为异步调用，调用此方法处直接返回，@Async标注的方法使用其他线程执行。
 *  第一行第二行对应async1()方法，第三行对应async2()方法，可以看到直接使用asyncService.async2()调用时使用的线程为SimpleAsyncTaskExecutor，
 *  而在async1()方法中使用this调用，结果却是主线程，原调用线程一致。这说明@Async在this调用时没有生效。
 * @author Toyon Shaw
 * @date 2021/11/3
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Starter.class)
public class BaseTest {

    @Autowired
    AsyncService asyncService;

    @Test
    public void testAsync() {
        asyncService.async1();
        asyncService.async2();
    }
}
