package com.toyonshaw.test.designmode.subscriber.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author toyon
 * @since 2023/6/29
 */
@Data
@Slf4j
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class EventADto<T> {

    /**
     * 名称
     */
    private String name;

    /**
     * 数据
     */
    private T data;

}
