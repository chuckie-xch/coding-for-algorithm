package com.bestcode.algorithm.leetcode.hot100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/11/26 3:12 PM
 **/
public class H009 {


    /**
     * 17. 电话号码的字母组合
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     * <p>
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * <p>
     * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/?favorite=2cktkvj
     *
     * @param digits
     * @return
     */
    public static List<String> solution(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTracking(result, numString, digits, 0, sb);
        return result;
    }

    private static void backTracking(List<String> result, String[] numString, String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String str = numString[digits.charAt(index) - '0'];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            backTracking(result, numString, digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
