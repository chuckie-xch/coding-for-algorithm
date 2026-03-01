package com.bestcode.algorithm.leetcode.hot100;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/11/26 10:15 AM
 **/
public class H007 {

    /**
     * 11. 盛水最多的容器
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * 返回容器可以储存的最大水量。
     * 说明：你不能倾斜容器。
     * <p>
     * https://leetcode.cn/problems/container-with-most-water/
     *
     * @param arr
     * @return
     */
    public static int solution(int[] arr) {
        int max = Integer.MIN_VALUE;
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            max = Math.max(max, Math.min(arr[l], arr[r]) * (r - l));
            if (arr[l] < arr[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
