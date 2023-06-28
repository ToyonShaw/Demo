package com.toyonshaw.test.sortalgorithm;

import com.alibaba.fastjson.JSON;

/**
 * <pre>
 *     选择排序
 * </pre>
 *
 * @author toyon
 * @since 2022/10/30
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = new int[]{88, 77, 66, 11, 22, 33};
        selectSortAsc(arr);
        System.out.println(JSON.toJSONString(arr));
    }

    public static void selectSortAsc(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int temp = i;
            for (int j = arr.length - 1; j > i; j--) {
                if (min > arr[j]) {
                    min = arr[j];
                    temp = j;
                }
            }
            arr[temp] = arr[i];
            arr[i] = min;
        }
    }


    public static void selectSortDesc(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int max = arr[i];
            int temp = i;
            for (int j = arr.length - 1; j > i; j--) {
                if (max < arr[j]) {
                    max = arr[j];
                    temp = j;
                }
            }
            arr[temp] = arr[i];
            arr[i] = max;
        }
    }





}
