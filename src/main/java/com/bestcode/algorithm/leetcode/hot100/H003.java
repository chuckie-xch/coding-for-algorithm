package com.bestcode.algorithm.leetcode.hot100;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/11/25 12:01 PM
 **/
public class H003 {

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
     *
     * @param s
     * @return
     */
    public static int solution(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] arr = s.toCharArray();
        int result = 1;
        int pre = 1;
        int[] location = new int[256];
        for (int i = 0; i < location.length; i++) {
            location[i] = -1;
        }
        location[arr[0]] = 0;
        int i = 1;
        while (i < arr.length) {
            int length = Math.min(pre + 1, i - location[arr[i]]);
            result = Math.max(result, length);
            pre = length;
            location[arr[i]] = i;
            i++;
        }
        return result;
    }
}
