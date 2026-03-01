package com.bestcode.algorithm.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/11/29 11:25 AM
 **/
public class H033 {

    /**
     * 78. 子集
     * <p>
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     * <p>
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     * <p>
     * https://leetcode.cn/problems/subsets/
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backTracking(result, path, nums, 0);
        return result;
    }

    private static void backTracking(List<List<Integer>> result, List<Integer> path, int[] nums, int i) {
        result.add(new ArrayList<>(path));
        for (int j = i; j < nums.length; j++) {
            path.add(nums[j]);
            backTracking(result,path, nums,j+1);
            path.remove(path.size()-1);
        }
    }


}
