package com.toyonshaw.test.designmode.subscriber.service;

import com.alibaba.fastjson.JSON;
import com.toyonshaw.test.designmode.subscriber.data.EventB;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * @author toyon
 * @since 2023/6/29
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ApplicationListenerB implements ApplicationListener<EventB> {
    @Override
    public void onApplicationEvent(EventB eventB) {
        log.info("-------- ApplicationListenerB  onApplicationEvent : {} ----------", JSON.toJSON(eventB.getDataDto()));
    }
}
