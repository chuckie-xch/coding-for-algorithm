package com.bestcode.algorithm.leetcode.hot100;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/2 6:25 PM
 **/
public class H063 {

    private static final Random random = new Random();

    /**
     * 215. 数组中的第K个最大元素
     * <p>
     * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
     * <p>
     * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * <p>
     * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
     * <p>
     * 提示：
     * <p>
     * 1 <= k <= nums.length <= 105
     * -104 <= nums[i] <= 104
     * <p>
     * https://leetcode.cn/problems/kth-largest-element-in-an-array/
     *
     * @param nums
     * @param k
     * @return
     */
    public static int solution(int[] nums, int k) {
        int len = nums.length;
        int target = len - k;
        int left = 0;
        int right = len - 1;
        while (true) {
            int[] pivotIndexArr = partition(nums, left, right);
            if (target >= pivotIndexArr[0] && target <= pivotIndexArr[1]) {
                return nums[pivotIndexArr[0]];
            } else if (target > pivotIndexArr[1]) {
                left = pivotIndexArr[1] + 1;
            } else {
                right = pivotIndexArr[0] - 1;
            }
        }
    }

    /**
     * 利用小根堆
     *
     * @param nums
     * @param k
     * @return
     */
    public static int solution2(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            heap.offer(nums[i]);
        }
        for (int i = k; i < len; i++) {
            int top = heap.peek();
            int cur = nums[i];
            if (cur > top) {
                heap.poll();
                heap.offer(cur);
            }
        }
        return heap.peek();
    }

    private static int[] partition(int[] nums, int left, int right) {
        int randomIndex = random.nextInt(right - left + 1) + left;
        swap(nums, randomIndex, right);
        int pivot = nums[right];
        int less = left - 1;
        int more = right;
        int index = left;
        while (index < more) {
            int cur = nums[index];
            if (cur < pivot) {
                swap(nums, index++, ++less);
            } else if (cur == pivot) {
                index++;
            } else {
                swap(nums, index, --more);
            }
        }
        swap(nums, more, right);
        return new int[]{less + 1, more};
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 5, 6, 4};
        int num = solution(arr, 2);
        System.out.println(num);
    }

    private static void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
