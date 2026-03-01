package com.bestcode.algorithm.leetcode.hot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/1 10:00 AM
 **/
public class H047 {

    /**
     * 128. 最长连续序列
     * <p>
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     * <p>
     * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 0 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     * <p>
     * https://leetcode.cn/problems/longest-consecutive-sequence/description/
     *
     * @param nums
     * @return
     */
    public static int solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int ans = 0;
        for (int num : nums) {
            if (set.contains(num - 1)) {
                continue;
            }
            int max = num + 1;
            while (true) {
                if (!set.contains(max)) {
                    break;
                } else {
                    max++;
                }
            }
            ans = Math.max(ans, max - num);
        }

        return ans;
    }

    public static int solution1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, num);
        }

        int ans = 0;

        for (int num : nums) {
            if (map.containsKey(num - 1)) {
                continue;
            }
            int maxRight = map.get(num);
            while (map.containsKey(maxRight + 1)) {
                maxRight = map.get(maxRight + 1);
            }
            map.put(num, maxRight);
            ans = Math.max(ans, maxRight - num + 1);
        }
        return ans;
    }


}
