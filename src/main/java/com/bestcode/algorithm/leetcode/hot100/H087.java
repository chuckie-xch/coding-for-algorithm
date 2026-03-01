package com.bestcode.algorithm.leetcode.hot100;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/8 5:23 PM
 **/
public class H087 {

    /**
     * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     * <p>
     * https://leetcode.cn/problems/partition-equal-subset-sum/
     *
     * @param nums
     * @return
     */
    public static boolean solution(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0;
        int maxNum = 0;
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            sum += cur;
            maxNum = Math.max(maxNum, cur);
        }
        if ((sum & 1) != 0) {
            return false;
        }
        int target = sum >> 1;
        if (maxNum > target) {
            return false;
        } else if (maxNum == target) {
            return true;
        }

        boolean[][] dp = new boolean[n][target + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            int cur = nums[i];
            for (int j = 1; j <= target; j++) {
                if (cur <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - cur];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n - 1][target];
    }
}
