package com.bestcode.algorithm.leetcode.hot100;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/11/26 4:47 PM
 **/
public class H011 {

    /**
     * 20. 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     * <p>
     * https://leetcode.cn/problems/valid-parentheses/?favorite=2cktkvj
     *
     * @param s
     * @return
     */
    public static boolean solution(String s) {
        if (s == null || s.length() == 0 || (s.length() & 1) != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> mathMap = new HashMap<>();
        mathMap.put('(', ')');
        mathMap.put('{', '}');
        mathMap.put('[', ']');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (mathMap.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char pre = stack.pop();
                if (!mathMap.containsKey(pre) || mathMap.get(pre) != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
