package com.bestcode.algorithm.exercrise;

import java.util.Arrays;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/10/10 5:18 PM
 **/
public class P008 {

    /**
     * 给定一个正数数组arr,代表若干人的体重，再给定一个正数limit，
     * 表示所有船共同拥有的载重量，每艘船最多做两人，且不能超过载重，
     * 想让所有人同时过河，并且用最少的分配方法让船尽可能少
     * 返回最少的船数
     * https://leetcode.cn/problems/boats-to-save-people/
     *
     * @param people
     * @param limit
     * @return
     */
    public static int solution(int[] people, int limit) {
        if (people == null || people.length == 0) {
            return 0;
        }
        Arrays.sort(people);
        int result = 0, length = people.length;
        if (people[length - 1] > limit) {
            return -1;
        }
        int k = limit / 2;
        int lessR = -1;
        for (int i = length - 1; i >= 0; i--) {
            if (people[i] <= k) {
                lessR = i;
                break;
            }
        }
        if (lessR == -1) {
            return length;
        }
        int l = lessR;
        int r = l + 1;
        int noUsed = 0;
        while (l >= 0) {
            int resolved = 0;
            while (r < length && people[l] + people[r] <= limit) {
                r++;
                resolved++;
            }
            if (resolved == 0) {
                l--;
                noUsed++;
            } else {
                l = l - resolved;
            }
        }
        int all = lessR + 1;
        int used = all - noUsed;
        int moreUnsolved = length - all - used;
        return used + ((noUsed + 1) >> 1) + moreUnsolved;
    }


}
