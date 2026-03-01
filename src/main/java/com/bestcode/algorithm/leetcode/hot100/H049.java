package com.bestcode.algorithm.leetcode.hot100;

import java.util.List;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/1 11:30 AM
 **/
public class H049 {

    /**
     * 139. 单词拆分
     * <p>
     * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
     * <p>
     * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
     * <p>
     * https://leetcode.cn/problems/word-break/
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 300
     * 1 <= wordDict.length <= 1000
     * 1 <= wordDict[i].length <= 20
     * s 和 wordDict[i] 仅有小写英文字母组成
     * wordDict 中的所有字符串 互不相同
     *
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean solution(String s, List<String> wordDict) {
        int len = s.length();
        if (len == 1) {
            return wordDict.contains(s);
        }
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        for (int i = 1; i <= len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (!dp[j]) {
                    continue;
                }
                String restStr = s.substring(j, i);
                if (wordDict.contains(restStr)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
