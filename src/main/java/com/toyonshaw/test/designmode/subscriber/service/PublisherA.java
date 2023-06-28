package com.toyonshaw.test.designmode.subscriber.service;

import com.toyonshaw.test.designmode.subscriber.data.EventA;
import com.toyonshaw.test.designmode.subscriber.data.EventB;
import com.toyonshaw.test.designmode.subscriber.data.EventBDto;
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
public class PublisherA {

    private final ApplicationEventPublisher publisher;
    private final PublisherB publisherB;

    public void publish(EventA eventA) {
        log.info("----------- PublisherA publish start ---------");
        publisher.publishEvent(eventA);
        log.info("----------- PublisherA publish publishEvent end  ---------");
        publisherB.publish(new EventB(eventA.getDataDto(), new EventBDto(eventA.getDataDto().getName(), eventA.getDataDto().getData())));
        log.info("----------- PublisherA publish 【publishB.publish】 end  ---------");
        log.info("----------- PublisherA publish end ---------");
    }


}
