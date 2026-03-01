package com.bestcode.algorithm.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/5 5:40 PM
 **/
public class H077 {

    /**
     * 301. 删除无效的括号
     * <p>
     * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
     * <p>
     * 返回所有可能的结果。答案可以按 任意顺序 返回。
     * <p>
     * https://leetcode.cn/problems/remove-invalid-parentheses/
     *
     * @param s
     * @return
     */
    public static List<String> solution(String s) {
        int lRemove = 0;
        int rRemove = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                lRemove++;
            } else if (arr[i] == ')') {
                if (lRemove == 0) {
                    rRemove++;
                } else {
                    lRemove--;
                }
            }
        }
        List<String> result = new ArrayList<>();
        remove(result, s, 0, lRemove, rRemove);
        return result;
    }

    public static List<String> solution2(String s) {
        List<String> result = new ArrayList<>();
        remove2(result, s, 0, 0, new char[]{'(', ')'});
        return result;
    }

    private static void remove2(List<String> result, String s, int checkIndex, int removeIndex, char[] par) {
        int count = 0;
        for (int i = checkIndex; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == par[0]) {
                count++;
            } else if (cur == par[1]) {
                count--;
            }
            if (count < 0) {
                for (int j = removeIndex; j <= i; j++) {
                    if (s.charAt(j) == par[1] && (j == removeIndex || s.charAt(j) != s.charAt(j - 1))) {
                        String newStr = s.substring(0, j) + s.substring(j + 1);
                        remove2(result, newStr, i, j, par);
                    }
                }
                return;
            }
        }
        String str = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') {
            remove2(result, str, 0, 0, new char[]{')', '('});
        } else {
            result.add(str);
        }
    }

    private static void remove(List<String> result, String s, int start, int lRemove, int rRemove) {
        if (lRemove == 0 && rRemove == 0) {
            if (isValid(s)) {
                result.add(s);
            }
            return;
        }
        for (int i = start; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (i != start && cur == s.charAt(i - 1)) {
                continue;
            }
            if (lRemove + rRemove > s.length() - i) {
                return;
            }
            if (cur == '(' || cur == ')') {
                String newStr = s.substring(0, i) + s.substring(i + 1);
                int newLRemove = cur == '(' ? lRemove - 1 : lRemove;
                int newRRemove = cur == ')' ? rRemove - 1 : rRemove;
                remove(result, newStr, i, newLRemove, newRRemove);
            }
        }
    }

    private static boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }
}
