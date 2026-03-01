package com.bestcode.algorithm.exercrise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/10/13 4:07 PM
 **/
public class P020 {

    public static class Info {
        private int t;
        private int f;

        public Info(int t, int f) {
            this.t = t;
            this.f = f;
        }
    }

    /**
     * 给定一个布尔表达式和一个期望的布尔结果 result，布尔表达式由 0 (false)、1 (true)、& (AND)、 | (OR) 和 ^ (XOR) 符号组成。
     * 实现一个函数，算出有几种可使该表达式得出 result 值的括号方法。
     * https://leetcode.cn/problems/boolean-evaluation-lcci/
     *
     * @param s
     * @return
     */
    public static int solution(String s, int result) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] arr = s.toCharArray();
        Map<Integer, Map<Integer, Info>> map = new HashMap<>();
        Info info = f(arr, 0, arr.length - 1,map);
        return result == 0 ? info.f : info.t;
    }

    private static Info f(char[] arr, int l, int r,Map<Integer, Map<Integer, Info>> map) {
        if (map.containsKey(l) && map.get(l).get(r) != null) {
            return map.get(l).get(r);
        }
        if (l == r) {
            int t = arr[l] == '1' ? 1 : 0;
            int f = arr[l] == '0' ? 1 : 0;
            Info info = new Info(t, f);
            Map<Integer, Info> m = new HashMap<>();
            m.put(l, info);
            map.put(l, m);
            return info;
        }
        int t = 0;
        int f = 0;
        for (int i = l + 1; i < r; i += 2) {
            Info left = f(arr, l, i - 1,map);
            Info right = f(arr, i + 1, r,map);

            if (arr[i] == '&') {
                t += left.t * right.t;
                f += left.f * right.f + left.t * right.f + left.f * right.t;
            } else if (arr[i] == '|') {
                t += left.t * right.t + left.t * right.f + left.f * right.t;
                f += left.f * right.f;
            } else if (arr[i] == '^') {
                t += left.f * right.t + left.t * right.f;
                f += left.f * right.f + left.t * right.t;
            }
        }
        Info info = new Info(t, f);
        if (!map.containsKey(l)) {
            Map<Integer, Info> m = new HashMap<>();
            m.put(r, info);
            map.put(l, m);
        } else {
            map.get(l).put(r, info);
        }
        return info;
    }
}
