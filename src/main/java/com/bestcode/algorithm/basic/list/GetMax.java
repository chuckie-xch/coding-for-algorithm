package com.bestcode.algorithm.basic.list;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/9/8 4:38 PM
 **/
public class GetMax {

    /**
     * 求数组中的最大值，用递归实现
     *
     * @param nums
     * @return
     */
    public static int getMax(int[] nums) {
        return process(nums, 0, nums.length - 1);
    }

    private static int process(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        int mid = l + ((r - l) >> 1);
        int lMax = process(nums, l, mid);
        int rMax = process(nums, mid + 1, r);
        return Math.max(lMax, rMax);
    }
}
