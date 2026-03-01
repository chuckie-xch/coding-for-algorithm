package com.bestcode.algorithm.leetcode.hot100;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/5 7:29 PM
 **/
public class H078 {

    /**
     * 309. 最佳买卖股票时机含冷冻期
     * <p>
     * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
     * <p>
     * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
     * <p>
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * <p>
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/
     *
     * @param prices
     * @return
     */
    public static int solution(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][3];
        // 0 持有 1 不持有，在冻结期  2 不持有，不在冻结期
        dp[0][0] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(Math.max(dp[len - 1][1], dp[len - 1][0]), dp[len - 1][2]);
    }

    public static int solution2(int[] prices) {
        int len = prices.length;
        // 0 持有 1 不持有，在冻结期  2 不持有，不在冻结期
        int d0 = -prices[0];
        int d1 = 0;
        int d2 = 0;
        for (int i = 1; i < len; i++) {
            int newD0 = Math.max(d0, d2 - prices[i]);
            int newD1 = d0 + prices[i];
            int newD2 = Math.max(d1, d2);
            d0 = newD0;
            d1 = newD1;
            d2 = newD2;
        }
        return Math.max(Math.max(d0, d1), d2);
    }

}
