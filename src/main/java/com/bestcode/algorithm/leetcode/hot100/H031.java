package com.bestcode.algorithm.leetcode.hot100;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/11/28 4:57 PM
 **/
public class H031 {

    /**
     * 75. 颜色分类
     * <p>
     * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * <p>
     * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     * <p>
     * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
     * <p>
     * https://leetcode.cn/problems/sort-colors/
     * <p>
     * 提示：
     * <p>
     * n == nums.length
     * 1 <= n <= 300
     * nums[i] 为 0、1 或 2
     *
     * @param nums
     */
    public static void solution(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int left = -1;
        int right = nums.length;
        int num = 1;
        int index = 0;
        while (index < right) {
            if (nums[index] < num) {
                if (index != ++left) {
                    swap(nums, index, left);
                }
                index++;
            } else if (nums[index] == num) {
                index++;
            } else {
                swap(nums, index, --right);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
//        int[] nums = new int[]{0, 1, 0};
//        solution(nums);
//        System.out.println(nums);
//

        String str = "aa";
        System.out.println("str" + str.substring(0,0));
    }
}
