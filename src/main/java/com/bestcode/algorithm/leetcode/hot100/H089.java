package com.bestcode.algorithm.leetcode.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/8 9:02 PM
 **/
public class H089 {

    /**
     * 438. 找到字符串中所有字母异位词
     * <p>
     * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
     * <p>
     * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
     * <p>
     * https://leetcode.cn/problems/find-all-anagrams-in-a-string/
     *
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> solution(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> window = new HashMap<>();

        int l = 0, r = 0;
        int valid = 0;
        while (r < s.length()) {
            char cur = s.charAt(r);
            r++;
            if (need.containsKey(cur)) {
                window.put(cur, window.getOrDefault(cur, 0) + 1);
                if (window.get(cur).equals(need.get(cur))) {
                    valid++;
                }
            }

            while (r - l >= p.length()) {
                if (valid == need.size()) {
                    ans.add(l);
                }
                char d = s.charAt(l);
                l++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return ans;
    }
}
