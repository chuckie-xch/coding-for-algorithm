package com.bestcode.algorithm.exercrise;

import java.util.Arrays;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/9/16 4:32 PM
 **/
public class P003 {

    /**
     * 给定一个二维数组matrix
     * 你可以从任意位置出发，走向上下左右四个方向
     * 返回可能走出来的最长的递增链长度
     *
     * @param matrix
     * @return
     */
    public static int solution1(int[][] matrix) {
        int res = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res = Math.max(res, process(matrix, i, j));
            }
        }
        return res;
    }


    public static int solution2(int[][] matrix) {
        int res = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res = Math.max(res, process1(matrix, i, j, dp));
            }
        }
        return res;
    }

    private static int process(int[][] matrix, int i, int j) {
        int value = matrix[i][j];
        int up = i > 0 && matrix[i - 1][j] > value ? process(matrix, i - 1, j) : 0;
        int down = i < (matrix.length - 1) && matrix[i + 1][j] > value ? process(matrix, i + 1, j) : 0;
        int left = j > 0 && matrix[i][j - 1] > value ? process(matrix, i, j - 1) : 0;
        int right = j < (matrix[0].length - 1) && matrix[i][j + 1] > value ? process(matrix, i, j + 1) : 0;
        return Math.max(Math.max(up, down), Math.max(left, right)) + 1;
    }

    private static int process1(int[][] matrix, int i, int j, int[][] dp) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int value = matrix[i][j];
        int up = i > 0 && matrix[i - 1][j] > value ? process(matrix, i - 1, j) : 0;
        int down = i < (matrix.length - 1) && matrix[i + 1][j] > value ? process(matrix, i + 1, j) : 0;
        int left = j > 0 && matrix[i][j - 1] > value ? process(matrix, i, j - 1) : 0;
        int right = j < (matrix[0].length - 1) && matrix[i][j + 1] > value ? process(matrix, i, j + 1) : 0;
        int res = Math.max(Math.max(up, down), Math.max(left, right)) + 1;
        dp[i][j] = res;
        return res;
    }


    public static void main(String[] args) {
        int n = 20;
        int m = 20;
        int max = 1000;
        int testTime = 10;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[][] arr = generateArray(n, m, max);
            int ans1 = solution1(arr);
            int ans2 = solution2(arr);
            if (ans1 != ans2) {
                System.out.println("ans1 = " + ans1 + ", ans2 = " + ans2);
                break;
            }
        }
        System.out.println("测试结束");
    }

    public static int[][] generateArray(int n, int m, int max) {
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = (int) (Math.random() * max);
            }
        }
        return ans;
    }

}
