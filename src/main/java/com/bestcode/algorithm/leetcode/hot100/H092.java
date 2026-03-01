package com.bestcode.algorithm.leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/8 10:29 PM
 **/
public class H092 {

    /**
     * 494. 目标和
     * <p>
     * 给你一个整数数组 nums 和一个整数 target 。
     * <p>
     * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
     * <p>
     * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
     * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
     * <p>
     * https://leetcode.cn/problems/target-sum/
     *
     * @param nums
     * @param target
     * @return
     */
    public static int solution(int[] nums, int target) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        return process(nums, 0, target, map);
    }

    public static int solution2(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || (diff & 1) != 0) {
            return 0;
        }

        int n = nums.length;
        int m = diff >> 1;
        int[][] dp = new int[n + 1][m + 1];

        dp[0][0] = 1;
        for (int i = 1; i < n + 1; i++) {
            int num = nums[i - 1];
            for (int j = 0; j < m + 1; j++) {
                if (num > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - num];
                }
            }
        }

        return dp[n][m];
    }


    private static int process(int[] nums, int i, int target, Map<Integer, Map<Integer, Integer>> map) {
        if (map.containsKey(i) && map.get(i).containsKey(target)) {
            return map.get(i).get(target);
        }
        if (i == nums.length) {
            return target == 0 ? 1 : 0;
        }
        int p1 = process(nums, i + 1, target - nums[i], map);
        int p2 = process(nums, i + 1, target + nums[i], map);
        int ans = p1 + p2;
        if (!map.containsKey(i)) {
            Map<Integer, Integer> res = new HashMap<>();
            res.put(target, ans);
            map.put(i, res);
        } else {
            map.get(i).put(target, ans);
        }
        return ans;
    }


}
