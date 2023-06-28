package com.toyonshaw.test.designmode.subscriber.service;

import com.alibaba.fastjson.JSON;
import com.toyonshaw.test.designmode.subscriber.data.EventC;
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
public class ApplicationListenerC implements ApplicationListener<EventC> {
    @Override
    public void onApplicationEvent(EventC eventC) {
        log.info("-------- ApplicationListenerC  onApplicationEvent : {}----------", JSON.toJSON(eventC.getDataDto()));
    }
}
