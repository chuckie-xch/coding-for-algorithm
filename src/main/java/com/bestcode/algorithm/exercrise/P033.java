package com.bestcode.algorithm.exercrise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/10/21 5:13 PM
 **/
public class P033 {

    /**
     * 超级水王：一个数组中大于n/2的数叫水王，判断一个数组中是否有水王，如果有返回该数，否则返回-1
     *
     * @param arr
     * @return
     */
    public static int solution(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int hp = 0;
        int candidate = 0;
        for (int i = 0; i < arr.length; i++) {
            if (hp == 0) {
                candidate = arr[i];
                hp = 1;
            } else if (candidate == arr[i]) {
                hp++;
            } else {
                hp--;
            }
        }

        if (hp == 0) {
            return -1;
        }
        hp = 0;
        for (int i = 0; i < arr.length; i++) {
            if (candidate == arr[i]) {
                hp++;
            }
        }
        if (hp > arr.length / 2) {
            return candidate;
        }
        return -1;
    }

    /**
     * 超级水王扩展，返回 > n/k 的数
     *
     * @param arr
     * @param k
     * @return
     */
    public static List<Integer> solution1(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                Integer hp = map.get(arr[i]);
                map.put(arr[i], ++hp);
            } else if (map.size() < k - 1) {
                map.put(arr[i], 1);
            } else {
                allCandidateMinusOne(map);
            }
        }
        Map<Integer, Integer> realNum = getRealAppearNumber(arr, map);
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : realNum.entrySet()) {
            if (entry.getValue() > arr.length / k) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    private static Map<Integer, Integer> getRealAppearNumber(int[] arr, Map<Integer, Integer> map) {
        Map<Integer, Integer> real = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                if (real.containsKey(arr[i])) {
                    real.put(arr[i], real.get(arr[i]) + 1);
                } else {
                    real.put(arr[i], 1);
                }
            }
        }
        return real;
    }

    private static void allCandidateMinusOne(Map<Integer, Integer> map) {
        List<Integer> removeKey = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value == 1) {
                removeKey.add(key);
            }
            map.put(key, --value);
        }
        for (Integer key : removeKey) {
            map.remove(key);
        }
    }
}
