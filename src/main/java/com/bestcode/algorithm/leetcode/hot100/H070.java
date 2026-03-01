package com.bestcode.algorithm.leetcode.hot100;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/5 9:31 AM
 **/
public class H070 {


    /**
     * 240. 搜索二维矩阵 II
     * <p>
     * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
     * <p>
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     * <p>
     * https://leetcode.cn/problems/search-a-2d-matrix-ii/
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean solution(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int row = 0;
        int col = m - 1;
        while (row < n && col >= 0) {
            int cur = matrix[row][col];
            if (cur == target) {
                return true;
            }
            if (cur < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
