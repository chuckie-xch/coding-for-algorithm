package com.bestcode.algorithm.exercrise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/10/12 10:32 AM
 **/
public class P016 {


    public static void main(String[] args) {
        List<String> str = solution("()())()");
        System.out.println(str);
    }

    /**
     * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
     * 返回所有可能的结果。答案可以按 任意顺序 返回。
     * https://leetcode.cn/problems/remove-invalid-parentheses/
     *
     * @param s
     * @return
     */
    public static List<String> solution(String s) {
        List<String> result = new ArrayList<>();
        remove(s, result, 0, 0, new char[]{'(', ')'});
        return result;
    }

    private static void remove(String s, List<String> result, int checkIndex, int deleteIndex, char[] par) {
        int count = 0;
        for (int i = checkIndex; i < s.length(); i++) {
            if (s.charAt(i) == par[0]) {
                count++;
            }
            if (s.charAt(i) == par[1]) {
                count--;
            }
            if (count < 0) {
                for (int j = deleteIndex; j <= i; j++) {
                    if (s.charAt(j) == par[1] && (j == deleteIndex || s.charAt(j - 1) != par[1])) {
                        String newStr = s.substring(0, j) + s.substring(j + 1);
                        remove(newStr, result, i, j, par);
                    }
                }
                return;
            }
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') {
            remove(reversed, result, 0, 0, new char[]{')', '('});
        } else {
            result.add(reversed);
        }
    }
}
