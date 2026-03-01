package com.bestcode.algorithm.exercrise;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/10/13 5:24 PM
 **/
public class P021 {

    /**
     * 谷歌面试扩展版
     * 面值为1-N的牌组成一组，
     * 每次从组里等概率的抽出1-n中的一张
     * 下次抽会换一个新的组，有无限组
     * 当累加和 < a时，你将一直抽牌
     * 当累加和 >=a 且 <b 时，你将获胜
     * 当累加和 >=b 时，你将失败
     * 返回获胜的概率，给定的参数为 N,a,b
     *
     * @param n
     * @param a
     * @param b
     * @return
     */
    public static double solution(int n, int a, int b) {
        if (a >= b || n < 1 || a < 1) {
            return 0;
        }
        if (b - a >= n) {
            return 1;
        }
        double p = f(0, n, a, b);
        return p;
    }

    private static double f(int sum, int n, int a, int b) {
        if (sum >= a && sum < b) {
            return 1;
        }
        if (sum >= b) {
            return 0;
        }
        double p = 0;
        for (int i = 1; i <= n; i++) {
            p += f(sum + i, n, a, b);
        }
        return p / n;
    }
}
