package com.bestcode.algorithm.exercrise;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/10/13 9:51 AM
 **/
public class P019 {

    /**
     * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     * 假设你总是可以到达数组的最后一个位置。
     * <p>
     * https://leetcode.cn/problems/jump-game-ii/
     *
     * @param arr
     * @return
     */
    public static int solution(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int cur = 0;
        int step = 0;
        int next = arr[0];
        int i = 1;
        while (i < arr.length) {
            if (cur < i) {
                step++;
                cur = next;
            }
            next = arr[i] + i > next ? arr[i] + i : next;
            i++;
        }
        return step;
    }
}
