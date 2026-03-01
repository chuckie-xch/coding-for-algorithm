package com.bestcode.algorithm.leetcode.hot100;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/3 4:46 PM
 **/
public class H068 {

    /**
     * 238. 除自身以外数组的乘积
     * <p>
     * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
     * <p>
     * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
     * <p>
     * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
     * <p>
     * https://leetcode.cn/problems/product-of-array-except-self/
     *
     * @param nums
     * @return
     */
    public static int[] solution(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = 1;
        right[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int j = nums.length - 2; j >= 0; j--) {
            right[j] = right[j + 1] * nums[j + 1];
        }
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }

    public static int[] solution2(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = 1;
        }
        int prefix = 1;
        int suffix = 1;
        for (int i = 0; i < len; i++) {
            ans[i] *= prefix;
            ans[len - i - 1] *= suffix;
            prefix *= nums[i];
            suffix *= nums[len - i - 1];
        }
        return ans;
    }
}
