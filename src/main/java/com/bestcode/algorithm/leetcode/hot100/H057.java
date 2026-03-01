package com.bestcode.algorithm.leetcode.hot100;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/2 3:46 PM
 **/
public class H057 {

    /**
     * 169. 多数元素
     * <p>
     * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     * <p>
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * <p>
     * https://leetcode.cn/problems/majority-element/
     * <p>
     * 提示：
     * n == nums.length
     * 1 <= n <= 5 * 104
     * -109 <= nums[i] <= 109
     *
     * @param nums
     * @return
     */
    public static int solution(int[] nums) {
        int hp = 1;
        int target = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (cur == target) {
                hp++;
            } else {
                hp--;
            }
            if (hp == 0) {
                target = cur;
                hp = 1;
            }
        }
        return target;
    }
}
