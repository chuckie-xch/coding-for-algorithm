package com.bestcode.algorithm.leetcode.hot100;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/5 11:28 AM
 **/
public class H074 {

    /**
     * 287. 寻找重复数
     * <p>
     * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
     * <p>
     * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
     * <p>
     * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
     * <p>
     * https://leetcode.cn/problems/find-the-duplicate-number/
     *
     * @param nums
     * @return
     */
    public static int solution(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return nums[slow];
    }
}
