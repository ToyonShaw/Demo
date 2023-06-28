package com.toyonshaw.test.objectreloding;

/**
 * @author toyon
 * @date 2022/4/19
 */
public class B extends A{

    public String show(B obj) {
        return ("B and B");
    }

    public String show(A obj) {
        return ("B and A");
    }


}
