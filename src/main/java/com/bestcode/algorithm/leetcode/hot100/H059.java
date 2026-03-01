package com.bestcode.algorithm.leetcode.hot100;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/2 4:58 PM
 **/
public class H059 {

    private static int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * 200. 岛屿数量
     * <p>
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * <p>
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     * <p>
     * 此外，你可以假设该网格的四条边均被水包围。
     * <p>
     * 提示：
     * <p>
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 300
     * grid[i][j] 的值为 '0' 或 '1'
     * <p>
     * https://leetcode.cn/problems/number-of-islands/
     *
     * @param grid
     * @return
     */
    public static int solution(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (m == 1 && n == 1) {
            return grid[0][0] == '1' ? 1 : 0;
        }
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    infect(grid, i, j, n, m);
                    ans++;
                }
            }
        }
        return ans;
    }

    private static void infect(char[][] grid, int i, int j, int n, int m) {
        grid[i][j] = '0';
        for (int[] direction : directions) {
            int newX = i + direction[0];
            int newY = j + direction[1];
            if (newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == '1') {
                infect(grid, newX, newY, n, m);
            }
        }
    }
}
