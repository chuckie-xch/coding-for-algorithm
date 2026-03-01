package com.bestcode.algorithm.exercrise;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/9/20 4:24 PM
 **/
public class P005 {

    /**
     * 现在有司机N*2人，调度中心会将所有的司机平均分给A、B两个区域
     * 第 i 个司机去 A 可得收入为 income[i][0],
     * 第 i 个司机去 B 可得收入为 income[i][1],
     * 返回所有调度方案中能使所有司机总收入最高的方案，是多少钱
     */
    public static int solution(int[][] income) {
        if (income == null || income.length < 2 || (income.length & 1) != 0) {
            return 0;
        }
        int n = income.length;
        int m = n >> 1;
        return process(income, 0, m);
    }

    private static int process(int[][] income, int index, int rest) {
        if (index == income.length) {
            return 0;
        }
        if (rest == 0) {
            return process(income, index + 1, 0) + income[index][1];
        }
        if (income.length - index - 1 == rest) {
            return process(income, index + 1, rest - 1) + income[index][0];
        }
        return Math.max(process(income, index + 1, 0) + income[index][1], process(income, index + 1, rest - 1) + income[index][0]);
    }
}
