package com.bestcode.algorithm.leetcode.hot100;

import java.util.Collection;
import java.util.Collections;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/11/29 9:04 AM
 **/
public class H032 {

    /**
     * 76. 最小覆盖子串
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     * <p>
     * 注意：
     * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
     * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
     * <p>
     * https://leetcode.cn/problems/minimum-window-substring/
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length, t.length <= 105
     * s 和 t 由英文字母组成
     *
     * @param s
     * @param t
     * @return
     */
    public static String solution(String s, String t) {
        String empty = "";
        if (t.length() > s.length()) {
            return empty;
        }
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < arr2.length; i++) {
            map[arr2[i]]++;
        }
        int need = arr2.length;
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int end = -1;
        while (right < arr1.length) {
            char c = arr1[right];
            map[c]--;
            if (map[c] >= 0) {
                need--;
            }
            if (need == 0) {
                while (map[arr1[left]] < 0) {
                    map[arr1[left++]]++;
                }
                need++;
                if (minLength > right - left + 1) {
                    start = left;
                    end = right;
                    minLength = right - left + 1;
                }
                map[arr1[left++]]++;
            }
            right++;
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        String result = solution("a", "a");
        System.out.println(result);
    }
}
