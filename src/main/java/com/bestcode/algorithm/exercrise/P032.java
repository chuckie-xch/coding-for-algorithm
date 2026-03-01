package com.bestcode.algorithm.exercrise;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/10/19 6:41 PM
 **/
public class P032 {

    public static class Node {
        private int value;

        private int row;

        private int col;

        public Node(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }

    /**
     * 给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
     * https://leetcode.cn/problems/trapping-rain-water-ii/
     *
     * @param arr
     * @return
     */
    public static int solution(int[][] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null || arr[0].length == 0) {
            return 0;
        }
        int n = arr.length;
        int m = arr[0].length;
        boolean[][] isEnter = new boolean[n][m];
        PriorityQueue<Node> heap = new PriorityQueue<Node>(Comparator.comparingInt(a -> a.value));
        for (int col = 0; col < m - 1; col++) {
            isEnter[0][col] = true;
            heap.add(new Node(arr[0][col], 0, col));
        }
        for (int row =  0; row < n-1; row++) {
            isEnter[row][m-1] = true;
            heap.add(new Node(arr[row][m-1], row, m-1));
        }
        for (int col =  m-1; col >0; col--) {
            isEnter[n-1][col] = true;
            heap.add(new Node(arr[n-1][col], n-1, col));
        }
        for (int row =  n-1; row >0; row--) {
            isEnter[row][0] = true;
            heap.add(new Node(arr[row][0], row, 0));
        }
        int water = 0;
        int max = 0;
        while (!heap.isEmpty()) {
            Node cur = heap.poll();
            max = Math.max(max, cur.value);
            int row = cur.row;
            int col = cur.col;
            if (row > 0 && !isEnter[row - 1][col]) {
                water += Math.max(0, max - arr[row - 1][col]);
                heap.add(new Node(arr[row - 1][col], row - 1, col));
                isEnter[row-1][col] = true;
            }
            if (row < n - 1 && !isEnter[row + 1][col]) {
                water += Math.max(0, max - arr[row + 1][col]);
                heap.add(new Node(arr[row + 1][col], row + 1, col));
                isEnter[row + 1][col] = true;
            }
            if (col > 0 && !isEnter[row][col-1]) {
                water += Math.max(0, max - arr[row][col-1]);
                heap.add(new Node(arr[row][col-1], row, col-1));
                isEnter[row][col-1] = true;
            }
            if (col < m - 1 && !isEnter[row][col+1]) {
                water += Math.max(0, max - arr[row][col+1]);
                heap.add(new Node(arr[row][col+1], row, col+1));
                isEnter[row][col+1] = true;
            }
        }
        return water;
    }
}
