package com.bestcode.algorithm.exercrise;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/10/12 6:13 PM
 **/
public class P018 {


    /**
     * 给定一个正数num,判断它是不是某个数的step sum
     * step sum : 比如 680, 680 + 68 + 6 = 754, 680的 step sum 叫754
     *
     * @param num
     * @return
     */
    public static boolean solution(int num) {
        int l = 0;
        int r = num;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            int stepSum = stepSum(mid);
            if (stepSum == num) {
                return true;
            } else if (stepSum > num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }

    private static int stepSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num;
            num = num / 10;
        }
        return sum;
    }
}
