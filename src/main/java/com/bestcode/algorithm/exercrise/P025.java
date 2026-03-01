package com.bestcode.algorithm.exercrise;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/10/17 10:11 AM
 **/
public class P025 {

    /**
     * 给定一个每一行有序，每一列也有序，整体可能无序的二维数组，在给定一个正数k，
     * 返回二维数组中，最小的第K个数
     *
     * @param arr
     * @param k
     * @return
     */
    public static int solution(int[][] arr, int k) {
        if (arr == null) {
            return 0;
        }
        int n = arr.length;
        int m = arr[0].length;
        int l = arr[0][0];
        int r = arr[n - 1][m - 1];
        int ans = 0;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            int[] result = f(arr, m, n, mid);
            if (result[0] >= k) {
                r = mid - 1;
                ans = result[1];
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    private static int[] f(int[][] arr, int m, int n, int value) {
        int row = 0;
        int col = m - 1;
        int near = Integer.MIN_VALUE;
        int num = 0;
        while (row < n && col >= 0) {
            if (arr[row][col] > value) {
                col--;
            } else {
                near = Math.max(near, arr[row][col]);
                num += col + 1;
                row++;
            }
        }
        return new int[]{num, near};
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2}, {1, 3}};
        int result = solution(arr, 1);
        System.out.println(result);
    }
}
