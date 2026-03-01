package com.bestcode.algorithm.leetcode.hot100;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/5 10:55 AM
 **/
public class H073 {

    /**
     * 283. 移动零
     * <p>
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     * <p>
     * https://leetcode.cn/problems/move-zeroes/
     *
     * @param nums
     */
    public static void solution(int[] nums) {
        int len = nums.length;
        int left = -1;
        int index = 0;
        while (index < len) {
            if (nums[index] != 0) {
                swap(nums, index, ++left);
            }
            index++;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
