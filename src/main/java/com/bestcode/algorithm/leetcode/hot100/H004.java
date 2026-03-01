package com.bestcode.algorithm.leetcode.hot100;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/11/25 4:03 PM
 **/
public class H004 {

    /**
     * 4. 寻找两个正序数组的中位数
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     * <p>
     * 算法的时间复杂度应该为 O(log (m+n)) 。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double solution(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] help = new int[m + n];
        boolean evenArr = (m + n) % 2 == 0;
        int endIndex = (m + n) / 2;
        int p1 = 0, p2 = 0;
        int i = 0;
        while (p1 < m && p2 < n) {
            help[i++] = nums1[p1] <= nums2[p2] ? nums1[p1++] : nums2[p2++];
        }
        while (p1 < m) {
            help[i++] = nums1[p1++];
        }
        while (p2 < n) {
            help[i++] = nums2[p2++];
        }
        double result = evenArr ? (help[endIndex] + help[endIndex - 1]) / 2.0 : help[endIndex];
        return result;
    }
}
