package com.bestcode.algorithm.leetcode.hot100;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/8 10:21 PM
 **/
public class H091 {

    /**
     * 461. 汉明距离
     * <p>
     * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
     * <p>
     * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
     * <p>
     * https://leetcode.cn/problems/hamming-distance/
     *
     * @param x
     * @param y
     * @return
     */
    public static int solution(int x, int y) {
        int eor = x ^ y;
        int ans = 0;
        while (eor != 0) {
            eor &= (eor - 1);
            ans++;
        }
        return ans;
    }
}
