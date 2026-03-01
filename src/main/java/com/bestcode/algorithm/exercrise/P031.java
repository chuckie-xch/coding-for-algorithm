package com.bestcode.algorithm.exercrise;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/10/19 6:20 PM
 **/
public class P031 {

    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * https://leetcode.cn/problems/trapping-rain-water/
     *
     * @param arr
     * @return
     */
    public static int solution(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int water = 0;
        int leftMax = arr[0];
        int rightMax = arr[arr.length - 1];
        int l = 1;
        int r = arr.length - 2;
        while (l <= r) {
            if (leftMax <= rightMax) {
                water += Math.max(0, leftMax - arr[l]);
                leftMax = Math.max(leftMax, arr[l++]);
            } else {
                water += Math.max(0, rightMax - arr[r]);;
                rightMax = Math.max(rightMax, arr[r--]);
            }
        }
        return water;
    }
}
