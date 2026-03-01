package com.bestcode.algorithm.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/11/27 5:58 PM
 **/
public class H021 {

    /**
     * 46. 全排列
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     * <p>
     * https://leetcode.cn/problems/permutations/
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backTracking(result, path, used, nums, 0);
        return result;
    }

    private static void backTracking(List<List<Integer>> result, List<Integer> path, boolean[] used, int[] nums, int count) {
        if (count == nums.length) {
            result.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                backTracking(result, path, used, nums, count + 1);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }


}
