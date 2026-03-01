package com.bestcode.algorithm.exercrise;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/10/14 11:19 AM
 **/
public class P023 {

    /**
     * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
     * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
     * https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
     *
     * @param n
     * @param m
     * @return
     */
    public static int solution(int n, int m) {
        int[] arr = new int[n];
        int[] delete = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        int rest = n;
        int p = 0;
        while (rest > 1) {
            int i = 1;
            while (i <= m) {
                if (delete[p] == 0) {
                    if (i == m) {
                        delete[p] = 1;
                    }
                    i++;
                }
                p = p + 1 == n ? 0 : p + 1;
            }
            rest--;
        }
        for (int i = 0; i < n; i++) {
            if (delete[i] == 0) {
                return arr[i];
            }
        }
        return -1;
    }

    public static int solution2(int n, int m) {
        return getLive(n, m) - 1;
    }

    public static int getLive(int n, int m) {
        if (n == 1) {
            return 1;
        }
        return (getLive(n-1,m) + m -1) % n + 1;
    }

}
