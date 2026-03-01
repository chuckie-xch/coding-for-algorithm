package com.bestcode.algorithm.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/8 9:54 PM
 **/
public class H090 {

    /**
     * 448. 找到所有数组中消失的数字
     * <p>
     * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
     * <p>
     * https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/
     *
     * @param nums
     * @return
     */
    public static List<Integer> solution(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int cur = Math.abs(nums[i]);
            if (nums[cur - 1] > 0) {
                nums[cur - 1] *= -1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
