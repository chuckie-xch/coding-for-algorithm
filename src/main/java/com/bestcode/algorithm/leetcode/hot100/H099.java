package com.bestcode.algorithm.leetcode.hot100;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/9 5:45 PM
 **/
public class H099 {

    /**
     * 647. 回文子串
     * <p>
     * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
     * <p>
     * 回文字符串 是正着读和倒过来读一样的字符串。
     * <p>
     * 子字符串 是字符串中的由连续字符组成的一个序列。
     * <p>
     * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
     * <p>
     * https://leetcode.cn/problems/palindromic-substrings/
     *
     * @param s
     * @return
     */
    public static int solution(String s) {
        int n = s.length();
        int ans = n;

        for (int i = 0; i < n; i++) {
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                ans++;
            }
        }

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                ans++;
                int left = i - 1;
                int right = i + 2;
                while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                    ans++;
                }
            }
        }

        return ans;
    }
}
