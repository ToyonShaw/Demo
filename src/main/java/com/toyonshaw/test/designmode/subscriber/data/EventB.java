package com.toyonshaw.test.designmode.subscriber.data;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

/**
 *
 * @author toyon
 * @since 2023/6/29
 */
@Getter
@Setter
@Accessors(chain = true)
@Slf4j
public class EventB extends ApplicationEvent {

    private EventBDto dataDto;

    public EventB(Object source, EventBDto dataDto) {
        super(source);
        this.dataDto = dataDto;
    }
}
