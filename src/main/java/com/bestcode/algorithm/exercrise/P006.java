package com.bestcode.algorithm.exercrise;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/10/10 4:12 PM
 **/
public class P006 {

    /**
     * 求最长无重复子串
     * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
     *
     * @param s
     * @return
     */
    public static int solution(String s) {
        if (null == s || s.equals("")) {
            return 0;
        }
        char[] arr = s.toCharArray();
        // map数组记录上次 arr[i] 出现的位置，也可以用map代替
        int[] map = new int[256];
        for (int i = 0; i < map.length; i++) {
            map[i] = -1;
        }
        map[arr[0]] = 0;
        int result = 1;
        int pre = 1;
        for (int i = 1; i < arr.length; i++) {
            pre = Math.min(i - map[arr[i]], pre + 1);
            map[arr[i]] = i;
            result = Math.max(result, pre);
        }
        return result;
    }
}
