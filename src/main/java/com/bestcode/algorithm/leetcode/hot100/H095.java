package com.bestcode.algorithm.leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/9 3:27 PM
 **/
public class H095 {

    /**
     * 560. 和为 K 的子数组
     * <p>
     * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
     * <p>
     * https://leetcode.cn/problems/subarray-sum-equals-k/
     *
     * @param nums
     * @param k
     * @return
     */
    public static int solution(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        int sum = 0;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int target = sum - k;
            if (map.containsKey(target)) {
                ans += map.get(target);
            }
            prefixSum[i] = sum;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
