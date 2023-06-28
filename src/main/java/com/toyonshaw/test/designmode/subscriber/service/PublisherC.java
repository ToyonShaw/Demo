package com.toyonshaw.test.designmode.subscriber.service;

import com.toyonshaw.test.designmode.subscriber.data.EventC;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * spring 发布订阅者模式
 *
 * @author toyon
 * @since 2023/6/29
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class PublisherC {

    private final ApplicationEventPublisher publisher;

    public void publish(EventC eventC) {
        log.info("----------- PublisherC publish start ---------");
        publisher.publishEvent(eventC);
        log.info("----------- PublisherC publish end ---------");
    }



}
