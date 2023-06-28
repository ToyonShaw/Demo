package com.toyonshaw.test.classloadsequence;

import lombok.extern.slf4j.Slf4j;

/**
 * @author toyon
 * @since 2022/10/27
 */
public class Father {

    public static String fatherVariate1 = "fatherA";
    public String fatherVariate2 = "fatherB";

    public Father() {
        System.out.println("--------- Father Constructor --------");
    }

    static {
        System.out.println("--------- Father static block --------");
    }

    public static void fatherStaticMethod() {
        System.out.println("--------- Father fatherStaticMethod --------");
    }

    public void fatherSimpleMethod() {
        System.out.println("--------- Father fatherSimpleMethod --------");
    }

}
