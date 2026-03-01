package com.bestcode.algorithm.leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/6 4:45 PM
 **/
public class H080 {

    private static int ans = Integer.MAX_VALUE;


    /**
     * 322. 零钱兑换
     * <p>
     * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
     * <p>
     * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
     * <p>
     * 你可以认为每种硬币的数量是无限的。
     * <p>
     * https://leetcode.cn/problems/coin-change/
     *
     * @param coins
     * @param amount
     * @return
     */
    public static int solution(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int[] dp = new int[amount+1];
        return process(dp, coins, amount);
    }

    private static int process(int[] dp, int[] coins, int rest) {
        if (rest == 0) {
            return 0;
        }
        if (rest < 0) {
            return -1;
        }
        if (dp[rest] != 0) {
            return dp[rest];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = process(dp, coins, rest - coins[i]);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        dp[rest] = min == Integer.MAX_VALUE ? -1 : min;
        return dp[rest];
    }
}
