package com.toyonshaw.test.objectreloding;

/**
 * @author toyon
 * @date 2022/4/19
 */
public class A {

    public String show(D obj) {
        return ("A and D");
    }

    public String show(A obj) {
        return ("A and A");
    }


}
