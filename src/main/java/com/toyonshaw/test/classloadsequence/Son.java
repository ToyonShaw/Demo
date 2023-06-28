package com.toyonshaw.test.classloadsequence;

/**
 * @author toyon
 * @since 2022/10/27
 */
public class Son extends Father {
    public static String sonVariate1 = "sonA";
    public String sonVariate2 = "fatherB";

    public Son() {
        System.out.println("--------- Son Constructor --------");
    }

    static {
        System.out.println("--------- Son static block --------");
    }

    public static void sonStaticMethod() {
        System.out.println("--------- Son sonStaticMethod --------");
    }

    public void sonSimpleMethod() {
        System.out.println("--------- Son sonSimpleMethod --------");
    }
}
