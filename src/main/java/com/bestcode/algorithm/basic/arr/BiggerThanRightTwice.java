package com.bestcode.algorithm.basic.arr;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/9/13 5:14 PM
 **/
public class BiggerThanRightTwice {


    /**
     * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
     * 你需要返回给定数组中的重要翻转对的数量。
     * https://leetcode.cn/problems/reverse-pairs
     *
     * @param nums
     * @return
     */
    public static int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return process(nums, 0, nums.length - 1);
    }

    public static int process(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return process(arr, l, mid) + process(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int middle = mid + 1;
        int sum = 0;
        for (int i = l; i <= mid; i++) {
            while (middle <= r && (long) arr[i] > (long) arr[middle] * 2) {
                middle++;
            }
            sum += middle - 1 - mid;
        }

        int p1 = l;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }

        while (p2 <= r) {
            help[i++] = arr[p2++];
        }

        for (int j = 0; j < help.length; j++) {
            arr[l + j] = help[j];
        }
        return sum;
    }
}
