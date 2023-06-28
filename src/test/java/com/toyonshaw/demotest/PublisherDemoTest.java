package com.toyonshaw.demotest;

import com.toyonshaw.test.designmode.subscriber.SubscriberDemo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author toyon
 * @since 2023/6/29
 */
@Slf4j
@SpringBootTest
public class PublisherDemoTest {

    @Resource
    private SubscriberDemo subscriberDemo;

    @Test
    public void demoTest() {
        subscriberDemo.testPublish();
    }

}
