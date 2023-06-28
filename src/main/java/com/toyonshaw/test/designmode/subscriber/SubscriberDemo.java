package com.toyonshaw.test.designmode.subscriber;

import com.toyonshaw.test.designmode.subscriber.data.EventA;
import com.toyonshaw.test.designmode.subscriber.data.EventADto;
import com.toyonshaw.test.designmode.subscriber.service.PublisherA;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * spring 发布订阅者模式
 *
 * @author toyon
 * @since 2023/6/29
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class SubscriberDemo {

    private final PublisherA publisherA;


    public void testPublish() {
        log.info("----------- SubscriberDemo testPublish start ---------");
        publisherA.publish(new EventA("toyonshaw test ~ ", new EventADto("toyonshaw test ~ ", "133~")));
        log.info("----------- SubscriberDemo testPublish end ---------");
    }


}
