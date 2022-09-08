package com.bestcode.algorithm.basic.search;

import com.bestcode.algorithm.basic.util.ArrayUtil;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/9/6 6:01 PM
 **/
public class BinarySearch {


    /**
     * 无序的整数数组，相邻位置一定不等，求出一个局部最小值(nums[i] < nums[i-1] && nums[i] < nums[i+1]), 任意一个即可，
     * 要求时间复杂度O(n)
     *
     * @return
     */
    public static int minValue(int[] nums) {
        if (nums == null || nums.length < 3) {
            return -1;
        }
        int length = nums.length;
        if (nums[0] < nums[1]) {
            return 0;
        }
        if (nums[length - 2] < nums[length - 1] && nums[length - 2] < nums[length - 3]) {
            return length - 2;
        }
        int l = 0;
        int r = length - 1;
        while (l < r) {
            int middle = l + ((r - l) >> 1);
            if (nums[middle] > nums[middle - 1]) {
                r = middle;
                continue;
            }
            if (nums[middle] > nums[middle + 1]) {
                r = middle;
                continue;
            }
            return middle;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = ArrayUtil.generateNonArray(100, 100);
        int minValueIndex = minValue(nums);
        if (minValueIndex == -1) {
            System.out.println("没找到!");
        } else {
            System.out.println("index:" + minValueIndex + ",value:" + nums[minValueIndex]);
            if (minValueIndex - 1 >= 0) {
                System.out.println("leftValue:" + nums[minValueIndex - 1]);
            }
            if (minValueIndex + 1 <= nums.length) {
                System.out.println("rightValue:" + nums[minValueIndex + 1]);
            }
        }

    }
}
