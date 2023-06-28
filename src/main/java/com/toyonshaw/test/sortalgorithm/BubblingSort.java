package com.toyonshaw.test.sortalgorithm;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     冒泡排序
 *
 * </pre>
 *
 * @author toyon
 * @since 2022/10/30
 */
public class BubblingSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3,1,5,7,8,2,4};
//        bubblingSortAsc(arr);
        bubblingSortDesc(arr);
        System.out.println(JSON.toJSONString(arr));
    }


    public static void bubblingSortAsc(int[] originalList) {
        for (int i = 0; i < originalList.length - 1; i++) {
            for(int j = 0; j < originalList.length -1 - i; j++) {
                if (originalList[j] > originalList[j+1] ) {
                    int temp = originalList[j];
                    originalList[j] = originalList[j+1];
                    originalList[j+1] = temp;

                }
            }
        }
    }

    public static void bubblingSortDesc(int[] originalList) {
        for (int i = 0; i < originalList.length - 1; i++) {
            for(int j = 0; j < originalList.length -1 - i; j++) {
                if (originalList[j] < originalList[j+1] ) {
                    int temp = originalList[j];
                    originalList[j] = originalList[j+1];
                    originalList[j+1] = temp;

                }
            }
        }
    }

}
