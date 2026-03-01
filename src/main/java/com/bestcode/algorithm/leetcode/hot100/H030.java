package com.bestcode.algorithm.leetcode.hot100;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/11/28 3:59 PM
 **/
public class H030 {

    /**
     * 72. 编辑距离
     * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
     * <p>
     * 你可以对一个单词进行如下三种操作：
     * <p>
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     * <p>
     * https://leetcode.cn/problems/edit-distance/
     *
     * @param word1
     * @param word2
     * @return
     */
    public static int solution(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        if (l1 == 0 || l2 == 0) {
            return l1 == 0 ? l2 : l1;
        }

        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int j = 1; j <= l2; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= l1; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                int costAdd = dp[i][j - 1] + 1;
                int costDelete = dp[i - 1][j] + 1;
                int costReplace = (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1) + dp[i - 1][j - 1];
                dp[i][j] = Math.min(Math.min(costAdd, costDelete), costReplace);
            }
        }
        return dp[l1][l2];
    }
}
