package com.bestcode.algorithm.exercrise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/10/17 3:34 PM
 **/
public class P027 {

    /**
     * 给定一个字符串 s，返回的所有子序列中有多少不同的字面值
     * https://leetcode.cn/problems/distinct-subsequences-ii/
     *
     * @param s
     * @return
     */
    public static int solution(String s) {
        char[] arr = s.toCharArray();
        int all = 1;
        int m = 1000000007;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : arr) {
            int newAdd = all;
            all = ((newAdd + all) % m - (map.containsKey(c) ? map.get(c) % m : 0) + m) % m;
            map.put(c, newAdd);
        }
        return all - 1;
    }



}
