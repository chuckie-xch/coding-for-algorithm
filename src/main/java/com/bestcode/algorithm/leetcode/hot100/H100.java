package com.bestcode.algorithm.leetcode.hot100;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/9 6:19 PM
 **/
public class H100 {

    /**
     * 739. 每日温度
     * <p>
     * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
     * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
     * <p>
     * https://leetcode.cn/problems/daily-temperatures/
     *
     * @param temperatures
     * @return
     */
    public static int[] solution(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int cur = temperatures[i];
            while (!deque.isEmpty() && cur > temperatures[deque.peekLast()]) {
                Integer index = deque.pollLast();
                ans[index] = i - index;
            }
            deque.addLast(i);
        }
//        while (!deque.isEmpty()) {
//            ans[deque.pollLast()] = 0;
//        }
        return ans;
    }
}
