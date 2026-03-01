package com.bestcode.algorithm.leetcode.hot100;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/11/28 3:46 PM
 **/
public class H029 {

    /**
     * 70. 爬楼梯
     * <p>
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * <p>
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * <p>
     * https://leetcode.cn/problems/climbing-stairs/
     *
     * @param n
     * @return
     */
    public static int solution(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int pre = 1;
        int cur = 2;
        for (int i = 3; i <= n; i++) {
            int num = cur + pre;
            pre = cur;
            cur = num;
        }
        return cur;
    }
}
