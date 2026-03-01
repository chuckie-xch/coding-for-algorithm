package com.bestcode.algorithm.leetcode.hot100;

import java.util.Arrays;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/9 5:11 PM
 **/
public class H098 {

    /**
     * 621. 任务调度器
     * <p>
     * 给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
     * <p>
     * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
     * <p>
     * 你需要计算完成所有任务所需要的 最短时间 。
     * <p>
     * https://leetcode.cn/problems/task-scheduler/
     *
     * @param tasks
     * @param n
     * @return
     */
    public static int solution(char[] tasks, int n) {
        int len = tasks.length;
        int[] hash = new int[26];
        for (int i = 0; i < len; i++) {
            hash[tasks[i] - 'A'] += 1;
        }
        Arrays.sort(hash);
        int min = (n + 1) * (hash[25] - 1) + 1;
        for (int i = 24; i >= 0; i--) {
            if (hash[i] == hash[25]) {
                min++;
            }
        }
        return Math.max(tasks.length, min);
    }
}
