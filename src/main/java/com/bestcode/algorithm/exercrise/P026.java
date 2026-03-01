package com.bestcode.algorithm.exercrise;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/10/17 11:34 AM
 **/
public class P026 {

    /**
     * 给定两个字符串s和t
     * 返回s的所有子序列中
     * 有多少个子序列的字面值等于t
     *
     * @param s
     * @param t
     * @return
     */
    public static int solution(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return 0;
        }
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        int l1 = arr1.length;
        int l2 = arr2.length;
        int[][] dp = new int[l1][l2];
        dp[0][0] = arr1[0] == arr2[0] ? 1 : 0;
        for (int i = 1; i < l1; i++) {
            dp[i][0] = dp[i - 1][0] + (arr1[i] == arr2[0] ? 1 : 0);
        }
        for (int i = 1; i < l1; i++) {
            for (int j = 1; j <= i && j < l2; j++) {
                dp[i][j] = dp[i-1][j];
                dp[i][j] = dp[i][j] + (arr1[i] == arr2[j] ? dp[i - 1][j - 1] : 0);
            }
        }
        return dp[l1 - 1][l2 - 1];
    }
}
