package com.bestcode.algorithm.leetcode.hot100;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/7 3:24 PM
 **/
public class H084 {

    /**
     * 394. 字符串解码
     * <p>
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     * <p>
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     * <p>
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     * <p>
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
     * <p>
     * https://leetcode.cn/problems/decode-string/
     *
     * @param s
     * @return
     */
    public static String solution(String s) {
        String[] ans = dfs(s, 0);
        return ans[0];
    }

    private static String[] dfs(String s, int index) {
        StringBuilder sb = new StringBuilder();
        int multi = 0;
        while (index < s.length()) {
            if (s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                multi = 10 * multi + Integer.parseInt(String.valueOf(s.charAt(index)));
            } else if (s.charAt(index) == '[') {
                String[] temp = dfs(s, index + 1);
                index = Integer.parseInt(temp[0]);
                while (multi > 0) {
                    sb.append(temp[1]);
                    multi--;
                }
            } else if (s.charAt(index) == ']') {
                return new String[]{String.valueOf(index), sb.toString()};
            } else {
                sb.append(s.charAt(index));
            }
            index++;
        }
        return new String[] {sb.toString()};
    }

    public static void main(String[] args) {
        String str = "30[a]2[bc]";
        String result = solution(str);
        System.out.println(result);
    }
}
