package com.bestcode.algorithm.exercrise;

import java.util.Arrays;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/10/10 4:48 PM
 **/
public class P007 {

    /**
     * 给定一个数组arr,代表每个人的能力值，再给定一个非负数k，
     * 如果两个人能力值正好差k，那么可以凑在一起比赛，一局比赛只能有两个人，
     * 返回最多可以同时有多少场比赛
     *
     * @param arr
     * @param k
     * @return
     */
    public static int solution(int[] arr, int k) {
        int minLength = 2;
        int length = arr.length;
        if (arr == null || length < minLength) {
            return 0;
        }
        int l = 0, r = 0, result = 0;
        Arrays.sort(arr);
        boolean[] used = new boolean[length];
        while (l < length && r < length) {
            if (used[l]) {
                l++;
            } else if (l >= r) {
                r++;
            } else {
                int distance = arr[r] - arr[l];
                if (distance == k) {
                    result++;
                    l++;
                    used[r++] = true;
                } else if (distance < k) {
                    r++;
                } else {
                    l++;
                }
            }
        }
        return result;
    }
}
