package com.bestcode.algorithm.exercrise;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/10/11 4:37 PM
 **/
public class P013 {

    /**
     * 给你两个单词word1 和word2， 请返回将word1转换成word2 所使用的最少代价 。
     * 你可以对一个单词进行如下三种操作：
     * 插入一个字符 代价 ic
     * 删除一个字符 代价 dc
     * 替换一个字符 代价 rc
     * 链接：https://leetcode.cn/problems/edit-distance
     *
     * @param s1
     * @param s2
     * @param ic
     * @param dc
     * @param rc
     * @return
     */
    public static int solution(String s1, String s2, int ic, int dc, int rc) {
        if (s1 == null || s2 == null) {
            return -1;
        }
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        int l1 = arr1.length;
        int l2 = arr2.length;
        // 用 i 个 arr1 编程成 j 个 arr2 所用的最小代价
        int[][] dp = new int[l1 + 1][l2 + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= l2; i++) {
            dp[0][i] = ic * i;
        }
        for (int i = 0; i <= l1; i++) {
            dp[i][0] = dc * i;
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                int costReplace = dp[i - 1][j - 1] + (arr1[i - 1] == arr2[j - 1] ? 0 : rc);
                int costAdd = dp[i][j-1] + ic;
                int costDelete = dp[i-1][j] + dc;
                dp[i][j] = Math.min(Math.min(costAdd, costReplace), costDelete);
            }
        }
        return dp[l1][l2];
    }
}
