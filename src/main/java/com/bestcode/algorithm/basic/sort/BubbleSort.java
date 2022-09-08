package com.bestcode.algorithm.basic.sort;

import com.bestcode.algorithm.basic.util.ArrayUtil;
import com.sun.xml.internal.bind.v2.model.util.ArrayInfoUtil;

import java.util.Arrays;

/**
 * @author chunhang.xch
 */
public class BubbleSort {


    /**
     * 冒泡排序，从0位置开始向后两两比较，每一轮将最大的数移动到数组末尾
     * 时间复杂度 O(n^2)，空间复杂度O(n)
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void swap1(int[] arr, int i, int j) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    public static void main(String[] args) {
        int[] arr1 = ArrayUtil.generateArray(100, 100);
        int[] arr2 = new int[arr1.length];
        System.arraycopy(arr1, 0, arr2, 0, arr1.length);
        Arrays.sort(arr1);
        bubbleSort(arr2);
        System.out.println(ArrayUtil.isEqual(arr1, arr2));
    }

}


