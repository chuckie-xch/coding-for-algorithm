package com.bestcode.algorithm.leetcode.hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/3 5:26 PM
 **/
public class H069 {

    /**
     * 239. 滑动窗口最大值
     * <p>
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     * <p>
     * 返回 滑动窗口中的最大值 。
     * <p>
     * https://leetcode.cn/problems/sliding-window-maximum/
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 105
     * -104 <= nums[i] <= 104
     * 1 <= k <= nums.length
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] solution(int[] nums, int k) {
        int len = nums.length;
        if (len == 1) {
            return nums;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[len - k + 1];

        int index = 0;

        for (int i = 0; i < len; i++) {
            int cur = nums[i];
            while (!deque.isEmpty() && cur >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);

            while (i - deque.peekFirst() + 1 > k) {
                deque.pollFirst();
            }

            if (i >= k - 1) {
                ans[index++] = nums[deque.peekFirst()];
            }
        }
        return ans;
    }
}
