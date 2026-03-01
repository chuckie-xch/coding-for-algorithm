package com.bestcode.algorithm.exercrise;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/10/11 10:24 AM
 **/
public class P011 {

    /**
     * 给定三个字符串s1、s2、s3，请你帮忙验证s3是否是由s1和s2 交错 组成的。
     * <p>
     * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
     * <p>
     * s = s1 + s2 + ... + sn
     * t = t1 + t2 + ... + tm
     * |n - m| <= 1
     * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
     * 注意：a + b 意味着字符串 a 和 b 连接。
     * <p>
     * https://leetcode.cn/problems/interleaving-string/
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public static boolean solution(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        char[] arr3 = s3.toCharArray();
        int l1 = arr1.length + 1;
        int l2 = arr2.length + 1;
        // 用 i 个 arr1 的字符 和 j 个 arr2 的字符是否能组成用 i+j 个 arr3
        boolean[][] dp = new boolean[l1][l2];
        dp[0][0] = true;
        // 填充第0行
        for (int j = 1; j < l2; j++) {
            if (arr2[j - 1] == arr3[j - 1]) {
                dp[0][j] = true;
            } else {
                break;
            }
        }
        // 填充第0列
        for (int i = 1; i < l1; i++) {
            if (arr1[i - 1] == arr3[i - 1]) {
                dp[i][0] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i < l1; i++) {
            for (int j = 1; j < l2; j++) {
                boolean r1 = false;
                if (arr1[i - 1] == arr3[i + j - 1]) {
                    r1 = dp[i - 1][j];
                }
                boolean r2 = false;
                if (arr2[j - 1] == arr3[i + j - 1]) {
                    r2 = dp[i][j - 1];
                }
                dp[i][j] = r1 || r2;
            }
        }
        return dp[l1 - 1][l2 - 1];
    }
}
