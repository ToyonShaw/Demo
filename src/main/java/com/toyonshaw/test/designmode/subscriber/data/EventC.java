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
public class EventC extends ApplicationEvent {

    private EventCDto dataDto;

    public EventC(Object source, EventCDto dataDto) {
        super(source);
        this.dataDto = dataDto;
    }
}
