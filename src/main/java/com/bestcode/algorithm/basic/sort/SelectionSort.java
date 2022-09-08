package com.bestcode.algorithm.basic.sort;

import com.bestcode.algorithm.basic.util.ArrayUtil;

import java.util.Arrays;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/9/6 3:26 PM
 **/
public class SelectionSort {

    /**
     * 0~N-1 上找出最小值放到 0 位置
     * 1~N-1 上找出最小值放到 1 位置
     *
     * @param arr
     */
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                ArrayUtil.swap(arr, i, minIndex);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = ArrayUtil.generateArray(100, 100);
        int[] arr2 = new int[arr1.length];
        System.arraycopy(arr1, 0, arr2, 0, arr1.length);
        Arrays.sort(arr1);
        selectionSort(arr2);
        System.out.println(ArrayUtil.isEqual(arr1, arr2));
    }
}
