package com.bestcode.algorithm.leetcode.hot100;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/2 4:14 PM
 **/
public class H058 {

    /**
     * 198. 打家劫舍
     * <p>
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * <p>
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     * <p>
     * https://leetcode.cn/problems/house-robber/
     * <p>
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 400
     *
     * @param nums
     * @return
     */
    public static int solution(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[1];
        if (n == 2) {
            return Math.max(dp[0], dp[1]);
        }
        dp[2] = nums[0] + nums[2];
        int ans = Math.max(dp[1], dp[2]);
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static int solution2(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }

    public static int solution3(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int prePre = nums[0];
        int pre = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int cur = Math.max(pre, prePre + nums[i]);
            prePre = pre;
            pre = cur;
        }
        return pre;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 9, 3, 1};
        int ans = solution(nums);
        System.out.println(ans);
    }
}
