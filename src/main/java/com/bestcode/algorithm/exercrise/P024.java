package com.bestcode.algorithm.exercrise;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/10/14 4:12 PM
 **/
public class P024 {

    /**
     * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
     * https://leetcode.cn/problems/repeated-substring-pattern
     *
     * @param s
     * @return
     */
    public static boolean solution(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }
}
