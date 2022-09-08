package com.bestcode.algorithm.basic.sort;

import com.bestcode.algorithm.basic.util.ArrayUtil;

import java.util.Arrays;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/9/6 5:22 PM
 **/
public class InsertionSort {

    /**
     * 0~1 上有序
     * 0~2 上有序
     * 0~3 上有序
     *
     * @param nums
     */
    public static void insertionSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    ArrayUtil.swap(nums, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = ArrayUtil.generateArray(100, 100);
        int[] arr2 = new int[arr1.length];
        System.arraycopy(arr1, 0, arr2, 0, arr1.length);
        Arrays.sort(arr1);
        insertionSort(arr2);
        System.out.println(ArrayUtil.isEqual(arr1, arr2));
    }
}
