package com.bestcode.algorithm.basic.search;

import com.bestcode.algorithm.basic.util.ArrayUtil;

import java.util.Arrays;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/9/8 3:10 PM
 **/
public class BsExist {

    /**
     * 给定一个有序的整数数组，判断某个数是否存在
     *
     * @return
     */
    public static boolean exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }
        int l = 0;
        int r = sortedArr.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (sortedArr[mid] == num) {
                return true;
            } else if (sortedArr[mid] > num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return sortedArr[l] == num;
    }

    public static boolean test(int[] sortedArr, int num) {
        for (int cur : sortedArr) {
            if (num == cur) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int testTime = 1000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] nums = ArrayUtil.generateArray(maxSize, maxValue);
            Arrays.sort(nums);
            int randomNum = (int) ((maxValue + 1) * Math.random());
            if (test(nums, randomNum) != exist(nums, randomNum)) {
                succeed = false;
                break;
            }
        }

        System.out.println(succeed == true ? "Nice!" : "Fucking fucked!");
    }

}
