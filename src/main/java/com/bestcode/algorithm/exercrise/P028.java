package com.bestcode.algorithm.exercrise;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/10/18 4:01 PM
 **/
public class P028 {

    /**
     * 给你一个大小为 n x n 的二元矩阵 grid ，其中 1 表示陆地，0 表示水域。
     * 岛 是由四面相连的 1 形成的一个最大组，即不会与非组内的任何其他 1 相连。grid 中 恰好存在两座岛 。
     * 你可以将任意数量的 0 变为 1 ，以使两座岛连接起来，变成 一座岛 。
     * 返回必须翻转的 0 的最小数目。
     * https://leetcode.cn/problems/shortest-bridge/description/
     *
     * @param arr
     * @return
     */
    public static int solution(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int all = n * m;
        int island = 0;
        int[] curs = new int[all];
        int[] nexts = new int[all];
        int[][] record = new int[2][all];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    int queueSize = infect(arr, i, j, n, m, curs, 0, record[island]);
                    int num = 1;
                    while (queueSize != 0) {
                        num++;
                        queueSize = bfs(n, m, all, num, curs, queueSize, nexts, record[island]);
                        int[] temp = curs;
                        curs = nexts;
                        nexts = temp;
                    }
                    island++;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < all; i++) {
            min = Math.min(min, record[0][i] + record[1][i]);
        }
        return min - 3;
    }

    private static int bfs(int n, int m, int all, int num, int[] curs, int size, int[] nexts, int[] records) {
        int nextIndex = 0;
        for (int i = 0; i < size; i++) {
            int index = curs[i];
            int up = index < m ? -1 : index - m;
            int down = index + m > all - 1 ? -1 : index + m;
            int left = index % m == 0 ? -1 : index - 1;
            int right = index % m == m - 1 ? -1 : index + 1;
            if (up != -1 && records[up] == 0) {
                nexts[nextIndex++] = up;
                records[up] = num;
            }
            if (down != -1 && records[down] == 0) {
                nexts[nextIndex++] = down;
                records[down] = num;
            }
            if (left != -1 && records[left] == 0) {
                nexts[nextIndex++] = left;
                records[left] = num;
            }
            if (right != -1 && records[right] == 0) {
                nexts[nextIndex++] = right;
                records[right] = num;
            }
        }
        return nextIndex;
    }

    private static int infect(int[][] arr, int i, int j, int n, int m, int[] curs, int index, int[] records) {
        if (i < 0 || i >= n || j < 0 || j >= m || arr[i][j] != 1) {
            return index;
        }
        arr[i][j] = -1;
        int p = i * m + j;
        records[p] = 1;
        curs[index++] = p;
        index = infect(arr, i - 1, j, n, m, curs, index, records);
        index = infect(arr, i + 1, j, n, m, curs, index, records);
        index = infect(arr, i, j - 1, n, m, curs, index, records);
        index = infect(arr, i, j + 1, n, m, curs, index, records);
        return index;
    }
}
