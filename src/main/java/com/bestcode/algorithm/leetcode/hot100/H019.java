package com.bestcode.algorithm.leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/11/27 4:26 PM
 **/
public class H019 {

    /**
     * 39. 组合总和
     * <p>
     * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
     * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
     * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
     * <p>
     * https://leetcode.cn/problems/combination-sum/?favorite=2cktkvj
     *
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> solution(int[] candidates, int target) {
        Arrays.sort(candidates);
        int maxIndex = moreThanTargetIndex(candidates, target) - 1;
        if (maxIndex < 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        backTracking(result, combine, candidates, 0, maxIndex, 0, target);
        return result;
    }

    private static void backTracking(List<List<Integer>> result, List<Integer> combine, int[] arr, int begin, int end, int sum, int target) {
        if (sum == target) {
            result.add(new ArrayList<>(combine));
            return;
        }
        for (int i = begin; i <= end && sum + arr[i] <= target; i++) {
            int res = sum + arr[i];
            combine.add(arr[i]);
            backTracking(result, combine, arr, i, end, res, target);
            combine.remove(combine.size() - 1);
        }
    }

    private static int moreThanTargetIndex(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return -1;
        }
        int ans = candidates.length;
        int l = 0, r = candidates.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (candidates[mid] > target) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 6, 7};
        List<List<Integer>> result = solution(arr, 7);
        System.out.println(result);
    }
}
