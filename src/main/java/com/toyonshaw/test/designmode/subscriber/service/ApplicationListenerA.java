package com.toyonshaw.test.designmode.subscriber.service;

import com.alibaba.fastjson.JSON;
import com.toyonshaw.test.designmode.subscriber.data.EventA;
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
public class ApplicationListenerA implements ApplicationListener<EventA> {
    @Override
    public void onApplicationEvent(EventA eventADto) {
        log.info("-------- ApplicationListenerA  onApplicationEvent : {} ----------", JSON.toJSON(eventADto.getDataDto()));
    }
}
