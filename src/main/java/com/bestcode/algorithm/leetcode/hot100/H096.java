package com.bestcode.algorithm.leetcode.hot100;

import java.util.Arrays;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/9 3:54 PM
 **/
public class H096 {

    /**
     * 581. 最短无序连续子数组
     * <p>
     * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
     * <p>
     * 请你找出符合题意的 最短 子数组，并输出它的长度。
     * <p>
     * https://leetcode.cn/problems/shortest-unsorted-continuous-subarray/
     *
     * @param nums
     * @return
     */
    public static int solution(int[] nums) {
        int n = nums.length;
        if (isSorted(nums)) {
            return 0;
        }
        int[] help = new int[n];
        System.arraycopy(nums, 0, help, 0, n);
        Arrays.sort(help);

        int left = 0;
        while (nums[left] == help[left]) {
            left++;
        }
        int right = n - 1;
        while (nums[right] == help[right]) {
            right--;
        }
        return right - left + 1;
    }

    public static int solution2(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int min = nums[n - 1];
        int left = 0;
        int right = -1;
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            if (cur < max) {
                right = i;
            } else {
                max = cur;
            }

            if (nums[n - 1 - i] > min) {
                left = n - 1 - i;
            } else {
                min = nums[n - 1 - i];
            }
        }
        return right - left + 1;
    }

    private static boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
