package com.bestcode.algorithm.leetcode.hot100;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/11/27 5:39 PM
 **/
public class H020 {

    /**
     * 42. 接雨水
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * <p>
     * https://leetcode.cn/problems/trapping-rain-water/?favorite=2cktkvj
     *
     * @param height
     * @return
     */
    public static int solution(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        int ans = 0;
        int lMax = height[0];
        int rMax = height[height.length - 1];
        int l = 1, r = height.length - 2;
        while (l <= r) {
            if (lMax < rMax) {
                ans += Math.max(0, lMax - height[l]);
                lMax = Math.max(lMax, height[l]);
                l++;
            } else {
                ans += Math.max(0, rMax - height[r]);
                rMax = Math.max(rMax, height[r]);
                r--;
            }
        }
        return ans;
    }
}
