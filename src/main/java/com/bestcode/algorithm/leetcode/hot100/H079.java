package com.bestcode.algorithm.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/6 2:30 PM
 **/
public class H079 {

    /**
     * 312. 戳气球
     * <p>
     * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
     * <p>
     * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
     * <p>
     * 求所能获得硬币的最大数量。
     * <p>
     * https://leetcode.cn/problems/burst-balloons/
     *
     * @param nums
     * @return
     */
    public static int solution(int[] nums) {
        int len = nums.length;
        int[] ans = new int[1];
        boolean[] used = new boolean[len];
        List<Integer> list = new ArrayList<>();
        process(nums, 0, used, list, ans);
        return ans[0];
    }

    public static int solution2(int[] nums) {
        int len = nums.length;
        int[] help = new int[len + 2];
        for (int i = 1; i <= len; i++) {
            help[i] = nums[i - 1];
        }
        help[0] = 1;
        help[len + 1] = 1;
        int[][] dp = new int[len + 2][len + 2];
        for (int i = 0; i < len + 2; i++) {
            for (int j = 0; j < len + 2; j++) {
                dp[i][j] = -1;
            }
        }
        solve(help, dp, 0, len + 1);
        return dp[0][len + 1];
    }

    private static int solve(int[] help, int[][] dp, int left, int right) {
        if (left >= right - 1) {
            return 0;
        }
        if (dp[left][right] != -1) {
            return dp[left][right];
        }
        for (int i = left + 1; i < right; i++) {
            int sum = help[left] * help[i] * help[right];
            sum += solve(help, dp, left, i) + solve(help, dp, i, right);
            dp[left][right] = Math.max(dp[left][right], sum);
        }
        return dp[left][right];
    }


    /**
     * 暴力回溯超时不通过 X
     *
     * @param nums
     * @param count
     * @param used
     * @param list
     * @param ans
     */
    private static void process(int[] nums, int count, boolean[] used, List<Integer> list, int[] ans) {
        if (count == nums.length) {
            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i);
            }
            ans[0] = Math.max(ans[0], sum);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            int cur = nums[i];
            int leftIndex = i - 1;
            while (leftIndex >= 0) {
                if (!used[leftIndex]) {
                    break;
                }
                leftIndex--;
            }
            int left = leftIndex < 0 ? 1 : nums[leftIndex];
            int rightIndex = i + 1;
            while (rightIndex < nums.length) {
                if (!used[rightIndex]) {
                    break;
                }
                rightIndex++;
            }
            int right = rightIndex >= nums.length ? 1 : nums[rightIndex];
            used[i] = true;
            list.add(cur * left * right);
            process(nums, count + 1, used, list, ans);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
