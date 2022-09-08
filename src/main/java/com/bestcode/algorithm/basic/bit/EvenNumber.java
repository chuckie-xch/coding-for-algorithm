package com.bestcode.algorithm.basic.bit;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/9/6 3:51 PM
 **/
public class EvenNumber {

    /**
     * 给定一个非空整数数组，除了某个元素只出现奇数次以外，其余每个元素均出现偶数次。找出那个只出现了奇数次的元素。
     * https://leetcode.cn/problems/single-number/
     *
     * @return
     */
    public static int getEvenNumber1(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result ^= arr[i];
        }
        return result;
    }

    /**
     * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
     * https://leetcode.cn/problems/single-number-ii/
     *
     * @param nums
     * @return
     */
    public static int getEvenNumber2(int[] nums) {
        return -1;
    }

    /**
     * 给定一个非空整数数组，有两种数出现奇数次，其他数出现偶数次，求这两种数
     * https://leetcode.cn/problems/single-number-iii/
     *
     * @return
     */
    public static int[] getEvenNumber3(int[] nums) {
        int eor = 0;
        for (int i = 0; i < nums.length; i++) {
            eor ^= nums[i];
        }
        int rightOne = eor & (~eor + 1);
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & rightOne) != 0) {
                result ^= nums[i];
            }
        }
        int a = result ^ eor;
        int b = a ^ eor;
        return new int[]{a, b};
    }
}
