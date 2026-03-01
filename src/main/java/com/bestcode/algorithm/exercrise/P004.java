package com.bestcode.algorithm.exercrise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/9/16 5:07 PM
 **/
public class P004 {

    /**
     * 给定一个数组arr，你可以在每个数字之前决定+或者-但是必须所有数字都参与
     * 再给定一个数target，请问最后算出target 的方法数是多少？
     *
     * @param arr
     * @return
     */
    public static int solution(int[] arr, int target) {
        return process(arr, 0, target);
    }

    private static int process(int[] arr, int i, int target) {
        if (i == arr.length) {
            return target == 0 ? 1 : 0;
        }
        return process(arr, i + 1, target - arr[i]) + process(arr, i + 1, target + arr[i]);
    }

    public static int solution2(int[] arr, int target) {
        return process2(arr, 0, target, new HashMap<>());
    }

    private static int process2(int[] arr, int index, int rest, Map<Integer, Map<Integer, Integer>> dp) {
        if (dp.containsKey(index) && dp.get(index).containsKey(rest)) {
            return dp.get(index).get(rest);
        }
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        int res = process2(arr, index + 1, rest - arr[index], dp) + process2(arr, index + 1, rest + arr[index], dp);
        if (!dp.containsKey(index)) {
            dp.put(index, new HashMap<>());
        }
        dp.get(index).put(res, res);
        return res;
    }
}
