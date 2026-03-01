package com.bestcode.algorithm.leetcode.hot100;

import java.util.*;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/11/28 9:38 AM
 **/
public class H023 {

    /**
     * 49. 字母异位词分组
     * <p>
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
     * <p>
     * https://leetcode.cn/problems/group-anagrams/
     *
     * @param s
     * @return
     */
    public static List<List<String>> solution(String[] s) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : s) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}
