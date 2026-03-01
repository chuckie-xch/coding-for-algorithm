package com.bestcode.algorithm.exercrise;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/10/11 9:30 AM
 **/
public class P009 {

    /**
     * 返回一个数组中，子数组的最大累加和
     * https://leetcode.cn/problems/maximum-subarray/
     *
     * @param arr
     * @return
     */
    public static int solution(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int pre = arr[0];
        int result = pre;
        for (int i = 1; i < arr.length; i++) {
            pre = Math.max(arr[i], pre + arr[i]);
            result = Math.max(result, pre);
        }
        return result;
    }
}
