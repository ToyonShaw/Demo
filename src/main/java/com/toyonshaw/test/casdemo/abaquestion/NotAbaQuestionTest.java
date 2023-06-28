package com.toyonshaw.test.casdemo.abaquestion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 原子引用的话，不存在aba问题 <br>
 *
 * @author toyon
 * @since 2022/10/23
 */
@Slf4j
public class NotAbaQuestionTest {
    public static void main(String[] args) {
        User z3 = new User("z3",25);
        User li4 = new User("li4",25);
        AtomicReference<User> atomicReference  = new AtomicReference<>();
        atomicReference.set(z3);
        log.info("-------------- atomicReference: {} --------------", atomicReference);
        boolean result = atomicReference.compareAndSet(z3, li4);
        log.info("-------------- result: {} ,     toString : {}--------------", result, atomicReference.get().toString());
        boolean result2 = atomicReference.compareAndSet(li4, z3);
        log.info("-------------- result: {} ,     toString : {}--------------", result2, atomicReference.get().toString());
    }

}

@AllArgsConstructor
@Data
class User {
    private String name;
    private int age;
}

