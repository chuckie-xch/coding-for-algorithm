package com.bestcode.algorithm.basic.arr;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/9/13 5:57 PM
 **/
public class PartitionNum {

    /**
     * 给定一个数组和一个数，使得小于等于number的数在左边，大于等于number的数在右边
     *
     * @param arr
     * @param num
     */
    public static void partitionNum(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int window = -1;
        int i = 0;
        while (i <= arr.length - 1) {
            if (arr[i] <= num) {
                swap(arr, i, window + 1);
                window++;
            }
            i++;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

}
