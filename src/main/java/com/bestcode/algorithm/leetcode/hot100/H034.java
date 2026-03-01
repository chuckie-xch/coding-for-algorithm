package com.bestcode.algorithm.leetcode.hot100;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/11/29 4:38 PM
 **/
public class H034 {


    /**
     * 79. 单词搜索
     * <p>
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     * <p>
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     * <p>
     * https://leetcode.cn/problems/word-search/description/
     * <p>
     * 提示：
     * <p>
     * m == board.length
     * n = board[i].length
     * 1 <= m, n <= 6
     * 1 <= word.length <= 15
     * board 和 word 仅由大小写英文字母组成
     *
     * @param board
     * @param word
     * @return
     */
    public static boolean solution(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean result = false;
        if (m * n < word.length()) {
            return result;
        }
        char firstChar = word.charAt(0);
        boolean[][] used = new boolean[m][n];
        int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == firstChar) {
                    used[i][j] = true;
                    if (dfs(i, j, 1, direction, used, word, board, m, n)) {
                        return true;
                    }
                    used[i][j] = false;
                }
            }
        }
        return result;
    }

    private static boolean dfs(int i, int j, int index, int[][] directions, boolean[][] used, String word, char[][] board, int m, int n) {
        if (index == word.length()) {
            return true;
        }
        for (int[] direction : directions) {
            int newX = i + direction[0];
            int newY = j + direction[1];
            if (newX < 0 || newX >= m || newY < 0 || newY >= n) {
                continue;
            }
            if (used[newX][newY]) {
                continue;
            }
            if (board[newX][newY] != word.charAt(index)) {
                continue;
            }
            used[newX][newY] = true;
            if (dfs(newX, newY, index + 1, directions, used, word, board, m, n)) {
                return true;
            }
            used[newX][newY] = false;
        }
        return false;
    }


}
