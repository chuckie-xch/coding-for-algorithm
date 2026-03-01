package com.bestcode.algorithm.leetcode.hot100;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/2 9:18 PM
 **/
public class H064 {

    /**
     * 221. 最大正方形
     * <p>
     * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
     * <p>
     * https://leetcode.cn/problems/maximal-square/
     * <p>
     * 提示：
     * <p>
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 300
     * matrix[i][j] 为 '0' 或 '1'
     *
     * @param matrix
     * @return
     */
    public static int solution(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (m == 1 && n == 1) {
            return matrix[0][0] - '0';
        }

        int[][] dp = new int[n][m];
        int ans = 0;

        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j] - '0';
            ans = Math.max(ans, dp[0][j]);
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = matrix[i][0] - '0';
            ans = Math.max(ans, dp[i][0]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                char cur = matrix[i][j];
                if (cur == '1') {
                    if (matrix[i][j - 1] == '0' || matrix[i - 1][j] == '0') {
                        dp[i][j] = 1;
                        ans = Math.max(ans, dp[i][j]);
                    } else {
                        int min = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
                        dp[i][j] = min + 1;
                        ans = Math.max(ans, dp[i][j]);
                    }
                }
            }
        }
        return ans * ans;
    }
}
