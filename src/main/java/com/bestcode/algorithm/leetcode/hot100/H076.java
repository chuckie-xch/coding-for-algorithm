package com.bestcode.algorithm.leetcode.hot100;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/5 12:07 PM
 **/
public class H076 {

    /**
     * 300. 最长递增子序列
     * <p>
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     * <p>
     * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
     * <p>
     * https://leetcode.cn/problems/longest-increasing-subsequence/
     *
     * @param nums
     * @return
     */
    public static int solution(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static int solution2(int[] nums) {
        int n = nums.length;
        int[] end = new int[n + 1];
        int len = 1;
        end[1] = nums[0];
        for (int i = 1; i < n; i++) {
            int cur = nums[i];
            if (cur > end[len]) {
                end[++len] = cur;
            } else {
                int l = 1;
                int r = len;
                int pos = 0;
                while (l <= r) {
                    int mid = l + ((r - l) >> 1);
                    if (end[mid] < cur) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                end[pos + 1] = cur;
            }
        }
        return len;
    }

    public static int solution3(int[] nums) {
        int n = nums.length;
        int[] end = new int[n + 1];
        int len = 1;
        end[1] = nums[0];
        for (int i = 1; i < n; i++) {
            int cur = nums[i];
            int index = findMinGreaterIndex(end, 1, len, cur);
            if (index == -1) {
                end[++len] = cur;
            } else {
                end[index] = cur;
            }
        }
        return len;
    }

    private static int findMinGreaterIndex(int[] arr, int begin, int end, int target) {
        int l = begin;
        int r = end;
        int index = -1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] >= target) {
                index = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 9, 2, 5, 3, 4};
        int len = solution2(arr);
        System.out.println(len);
    }
}
