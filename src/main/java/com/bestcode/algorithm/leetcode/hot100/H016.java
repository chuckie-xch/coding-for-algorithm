package com.bestcode.algorithm.leetcode.hot100;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/11/27 10:04 AM
 **/
public class H016 {

    /**
     * 32. 最长有效括号
     * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
     * <p>
     * https://leetcode.cn/problems/longest-valid-parentheses/?favorite=2cktkvj
     *
     * @param s
     * @return
     */
    public static int solution(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        char[] arr = s.toCharArray();
        int max = 0;
        int open = 0, close = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                open++;
            } else {
                close++;
            }
            if (open == close) {
                max = Math.max(max, close * 2);
            } else if (close > open) {
                open = 0;
                close = 0;
            }
        }
        open = 0;
        close = 0;
        for (int j = arr.length - 1; j >= 0; j--) {
            if (arr[j] == '(') {
                open++;
            } else {
                close++;
            }
            if (open == close) {
                max = Math.max(max, open * 2);
            } else if (open > close) {
                open = 0;
                close = 0;
            }
        }
        return max;
    }

    public static int solution1(String s) {
        int max = 0;
        if (s == null || s.length() < 2) {
            return 0;
        }
        char[] arr = s.toCharArray();

        int[] dp = new int[arr.length];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == ')') {
                if (arr[i - 1] == '(') {
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                } else {
                    if (i - dp[i - 1] - 1 >= 0 && arr[i - dp[i - 1] - 1] == '(') {
                        dp[i] = (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + dp[i - 1] + 2;
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
