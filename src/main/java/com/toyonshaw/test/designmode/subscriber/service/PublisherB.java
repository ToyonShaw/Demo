package com.toyonshaw.test.designmode.subscriber.service;

import com.toyonshaw.test.designmode.subscriber.data.EventB;
import com.toyonshaw.test.designmode.subscriber.data.EventC;
import com.toyonshaw.test.designmode.subscriber.data.EventCDto;
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
public class PublisherB {

    private final ApplicationEventPublisher publisher;
    private final PublisherC publisherC;

    public void publish(EventB eventB) {
        log.info("----------- PublisherB publish start ---------");
        publisher.publishEvent(eventB);
        log.info("----------- PublisherB publish publishEvent end  ---------");
        publisherC.publish(new EventC("133", new EventCDto(eventB.getDataDto().getName(), eventB.getDataDto().getData())));
        log.info("----------- PublisherB publish 【publishC.publish】 end  ---------");
        log.info("----------- PublisherB publish end ---------");
    }



}
