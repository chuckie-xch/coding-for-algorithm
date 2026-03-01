package com.bestcode.algorithm.leetcode.hot100;

import java.util.*;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/11/26 11:51 AM
 **/
public class H008 {

    /**
     * 15. 三数之和
     * <p>
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
     * 你返回所有和为 0 且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     * <p>
     * https://leetcode.cn/problems/3sum/?favorite=2cktkvj
     *
     * @param arr
     * @return
     */
    public static List<List<Integer>> solution(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            // 去重a
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = arr.length - 1;
            int a = arr[i];
            while (left < right) {
                int b = arr[left];
                int c = arr[right];
                int sum = a + b + c;
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    List<Integer> list = Arrays.asList(a, b, c);
                    result.add(list);
                    while (left < right && arr[left] == arr[left + 1]) {
                        left++;
                    }
                    while (left < right && arr[right] == arr[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return result;
    }


}
