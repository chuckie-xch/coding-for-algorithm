package com.bestcode.algorithm.leetcode.hot100;

import java.util.*;


/**
 * @author chunhang.xch
 * @Description
 * @date 2022/11/26 5:30 PM
 **/
public class H013 {


    /**
     * 22. 括号生成
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * <p>
     * https://leetcode.cn/problems/generate-parentheses/?favorite=2cktkvj
     *
     * @param n
     * @return
     */
    public static List<String> solution(int n) {
        if (n <= 0) {
            return Collections.emptyList();
        }
        List<String> list = Arrays.asList("()");
        if (n == 1) {
            return list;
        }
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backTracking(result, 0, 0, n, sb);
        return result;
    }

    private static void backTracking(List<String> result, int open, int close, int max, StringBuilder sb) {
        if (sb.length() == max * 2) {
            result.add(sb.toString());
            return;
        }
        if (open < max) {
            sb.append('(');
            backTracking(result, open + 1, close, max, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(')');
            backTracking(result, open, close + 1, max, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


}
