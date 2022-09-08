package com.bestcode.algorithm.basic.arr;

import com.bestcode.algorithm.basic.util.ArrayUtil;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/9/8 5:22 PM
 **/
public class SmallSum {

    /**
     * 一个数组中，一个数左边比它小的数的总和，叫数的小和，所有数的小和累加起来叫做数组的小和，求数组小和
     *
     * @param nums
     * @return
     */
    public static int smallSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return process(nums, 0, nums.length - 1);
    }

    /**
     * 让 arr 的 [l,r] 上排好序也返回小和
     *
     * @param nums
     * @param l
     * @param r
     * @return
     */
    private static int process(int[] nums, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return process(nums, l, mid) + process(nums, mid + 1, r) + merge(nums, l, mid, r);
    }

    private static int merge(int[] nums, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;
        int i = 0;
        int sum = 0;
        while (p1 <= mid && p2 <= r) {
            sum += nums[p1] < nums[p2] ? (r - p2 + 1) * nums[p1] : 0;
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
        return sum;
    }

    public static int comparator(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                res += arr[j] < arr[i] ? arr[j] : 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int testTime = 500;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = ArrayUtil.generateArray(maxSize, maxValue);
            int[] arr2 = new int[arr1.length];
            System.arraycopy(arr1, 0, arr2, 0, arr1.length);
            if (smallSum(arr1) != comparator(arr2)) {
                succeed = false;
                ArrayUtil.printArray(arr1);
                ArrayUtil.printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
