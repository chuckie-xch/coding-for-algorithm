package com.bestcode.algorithm.leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/11/28 10:38 AM
 **/
public class H026 {

    /**
     * 56. 合并区间
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
     * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
     * <p>
     * https://leetcode.cn/problems/merge-intervals/
     *
     * @param intervals
     * @return
     */
    public static int[][] solution(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; ) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i + 1 < intervals.length && right >= intervals[i + 1][0]) {
                right = Math.max(right, intervals[i + 1][1]);
                i++;
            }
            result.add(new int[]{left, right});
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }

    public static int[][] solution1(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int index = 1;
        boolean[] unUsed = new boolean[intervals.length];
        int count = 0;
        while (index < intervals.length) {
            if (intervals[index][0] <= intervals[index - 1][1]) {
                unUsed[index - 1] = true;
                count++;
                intervals[index][0] = intervals[index - 1][0];
                intervals[index][1] = Math.max(intervals[index][1], intervals[index - 1][1]);
            }
            index++;
        }
        int[][] result = new int[intervals.length - count][2];
        int j = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (unUsed[i]) {
                continue;
            }
            result[j][0] = intervals[i][0];
            result[j][1] = intervals[i][1];
            j++;
        }
        return result;
    }


    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 4}, {0, 4}};
        int[][] result = solution(arr);
        System.out.println(result);

    }
}
