package com.bestcode.algorithm.basic.sort;

import com.bestcode.algorithm.basic.util.ArrayUtil;

import java.util.Arrays;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/9/8 4:49 PM
 **/
public class MergeSort {

    /**
     * 左边排好序+右边排好序+merge 让整体有序
     *
     * @param nums
     */
    public static void mergeSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        process(nums, 0, nums.length - 1);
    }

    private static void process(int[] nums, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        process(nums, l, mid);
        process(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    public static void merge(int[] nums, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= r) {
            help[i++] = nums[p1] < nums[p2] ? nums[p1++] : nums[p2++];
        }
        while (p1 <= mid) {
            help[i++] = nums[p1++];
        }
        while (p2 <= r) {
            help[i++] = nums[p2++];
        }
        for (i = 0; i < help.length; i++) {
            nums[l + i] = help[i];
        }
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = ArrayUtil.generateArray(maxSize, maxValue);
            int[] arr2 = new int[arr1.length];
            System.arraycopy(arr1, 0, arr2, 0, arr1.length);
            mergeSort(arr1);
            Arrays.sort(arr2);
            if (!ArrayUtil.isEqual(arr1, arr2)) {
                System.out.println("出错了！");
                ArrayUtil.printArray(arr1);
                ArrayUtil.printArray(arr2);
                break;
            }
        }
        System.out.println("测试结束");
    }
}
