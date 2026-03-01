package com.bestcode.algorithm.leetcode.hot100;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/2 2:43 PM
 **/
public class H054 {


    /**
     * 152. 乘积最大子数组
     * <p>
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     * <p>
     * 测试用例的答案是一个 32-位 整数。
     * <p>
     * 子数组 是数组的连续子序列。
     * <p>
     * 提示:
     * <p>
     * 1 <= nums.length <= 2 * 104
     * -10 <= nums[i] <= 10
     * nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数
     * <p>
     * https://leetcode.cn/problems/maximum-product-subarray/
     *
     * @param nums
     * @return
     */
    public static int solution(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(Math.max(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]), nums[i]);
            dp[i][1] = Math.min(Math.min(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]), nums[i]);
            ans = Math.max(dp[i][0], ans);
        }
        return ans;
    }

    public static int solution2(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        int preMax = ans;
        int preMin = ans;
        for (int i = 1; i < n; i++) {
            int cur = nums[i];
            int max = Math.max(Math.max(preMax * cur, preMin * cur), cur);
            int min = Math.min(Math.min(preMax * cur, preMin * cur), cur);
            ans = Math.max(max, ans);
            preMax = max;
            preMin = min;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-4, -3, -2};
        int ans = solution2(nums);
        System.out.println(ans);
    }
}
