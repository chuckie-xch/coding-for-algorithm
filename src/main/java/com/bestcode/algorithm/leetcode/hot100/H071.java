package com.bestcode.algorithm.leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/5 9:42 AM
 **/
public class H071 {

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /**
     * 会议室II
     * <p>
     * 给你一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时
     * 间 intervals[i] = [starti, endi] ，为避免会议冲突，同时要考虑充分利用会
     * 议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。
     * <p>
     * https://leetcode.cn/problems/meeting-rooms-ii/
     *
     * @param intervals
     * @return
     */
    public static int solution(int[][] intervals) {
        int n = intervals.length;
        Interval[] arr = new Interval[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Interval(intervals[i][0], intervals[i][1]);
        }
        int need = process(arr);
        return need;
    }

    private static int process(Interval[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o.end));
        List<Interval> rest = new ArrayList<>();
        int pre = 0;
        int i = 1;
        while (i < arr.length) {
            if (arr[i].start < arr[pre].end) {
                rest.add(arr[i]);
            } else {
                pre = i;
            }
            i++;
        }
        return 1 + process(rest.toArray(new Interval[rest.size()]));
    }
}
