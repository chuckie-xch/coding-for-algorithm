package com.bestcode.algorithm.leetcode.hot100;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/6 7:10 PM
 **/
public class H082 {

    /**
     * 338. 比特位计数
     * <p>
     * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
     * <p>
     * https://leetcode.cn/problems/counting-bits/
     *
     * @param n
     * @return
     */
    public static int[] solution(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            int cur = i;
            int cnt = 0;
            while (cur != 0) {
                cur &= (cur - 1);
                cnt++;
            }
            ans[i] = cnt;
        }
        return ans;
    }
}
