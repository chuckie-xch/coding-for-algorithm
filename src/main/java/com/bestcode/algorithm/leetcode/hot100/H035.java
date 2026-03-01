package com.bestcode.algorithm.leetcode.hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/11/29 5:59 PM
 **/
public class H035 {


    /**
     * 84. 柱状图中最大的矩形
     * <p>
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
     * <p>
     * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
     * <p>
     * https://leetcode.cn/problems/largest-rectangle-in-histogram/
     * <p>
     * 提示：
     * <p>
     * 1 <= heights.length <=105
     * 0 <= heights[i] <= 104
     *
     * @param heights
     * @return
     */
    public static int solution(int[] heights) {
        int n = heights.length;
        if (n == 1) {
            return heights[0];
        }
        int[] help = new int[n + 2];
        System.arraycopy(heights, 0, help, 1, n);
        help[0] = 0;
        help[n + 1] = 0;
        int ans = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);
        for (int i = 1; i < help.length; i++) {
            while (help[i] < help[deque.peekLast()]) {
                int height = help[deque.pollLast()];
                ans = Math.max(ans, height * (i - deque.peekLast() - 1));
            }
            deque.addLast(i);
        }
        return ans;
    }
}
