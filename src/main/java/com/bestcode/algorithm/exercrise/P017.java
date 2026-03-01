package com.bestcode.algorithm.exercrise;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/10/12 4:35 PM
 **/
public class P017 {

    /**
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
     * <p>
     * https://leetcode.cn/problems/longest-increasing-subsequence/
     *
     * @param arr
     * @return
     */
    public static int solution(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int l = arr.length;
        int[] dp = new int[l];
        dp[0] = 1;
        int result = 1;
        for (int i = 1; i < l; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            result = Math.max(dp[i], result);
        }
        return result;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        solution2(arr);
    }

    public static int solution2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int l = arr.length;
        // 记录长度为 i+1 的子序列中末尾位置的最小值
        int[] end = new int[l];
        end[0] = arr[0];
        int right = 0;
        for (int i = 1; i < l; i++) {
            int index = findGreaterThan(end, right, arr[i]);
            if (index == -1) {
                end[++right] = arr[i];
            } else {
                end[index] = arr[i];
            }
        }
        return right + 1;
    }

    private static int findGreaterThan(int[] arr, int right, int value) {
        int l = 0;
        int r = right;
        int index = -1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return index;
    }
}
