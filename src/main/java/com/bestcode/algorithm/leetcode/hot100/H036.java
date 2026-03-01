package com.bestcode.algorithm.leetcode.hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/11/29 7:47 PM
 **/
public class H036 {

    /**
     * 85. 最大矩形
     * <p>
     * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
     * <p>
     * https://leetcode.cn/problems/maximal-rectangle/
     * <p>
     * 提示：
     * <p>
     * rows == matrix.length
     * cols == matrix[0].length
     * 1 <= row, cols <= 200
     * matrix[i][j] 为 '0' 或 '1'
     *
     * @param matrix
     * @return
     */
    public static int solution(char[][] matrix) {
        int ans = 0;

        int n = matrix.length;
        int m = matrix[0].length;

        int[] height = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    height[j] += 1;
                } else {
                    height[j] = 0;
                }
            }
            ans = Math.max(ans, getMaxArea(height));
        }
        return ans;
    }

    private static int getMaxArea(int[] height) {
        int n = height.length;
        if (n == 1) {
            return height[0];
        }
        int[] help = new int[n + 2];
        System.arraycopy(height, 0, help, 1, n);
        help[0] = 0;
        help[n + 1] = 0;
        int ans = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);
        for (int i = 1; i < help.length; i++) {
            while (help[i] < help[deque.peekLast()]) {
                int curHeight = help[deque.pollLast()];
                ans = Math.max(ans, curHeight * (i - deque.peekLast() - 1));
            }
            deque.addLast(i);
        }
        return ans;
    }
}
