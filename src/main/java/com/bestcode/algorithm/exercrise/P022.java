package com.bestcode.algorithm.exercrise;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/10/13 6:15 PM
 **/
public class P022 {

    /**
     * 假设有 n 台超级洗衣机放在同一排上。开始的时候，每台洗衣机内可能有一定量的衣服，也可能是空的。
     * 在每一步操作中，你可以选择任意 m (1 <= m <= n) 台洗衣机，与此同时将每台洗衣机的一件衣服送到相邻的一台洗衣机。
     * 给定一个整数数组 machines 代表从左至右每台洗衣机中的衣物数量，请给出能让所有洗衣机中剩下的衣物的数量相等的 最少的操作步数 。
     * 如果不能使每台洗衣机中衣物的数量相等，则返回 -1 。
     * https://leetcode.cn/problems/super-washing-machines/
     *
     * @param arr
     * @return
     */
    public static int solution(int[] arr) {
        int l = arr.length;
        if (arr == null || l == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < l; i++) {
            sum += arr[i];
        }
        if (sum % l != 0) {
            return -1;
        }
        int avg = sum / l;
        int result = 0;
        int leftSum = 0;
        for (int i = 0; i < l; i++) {
            int cur = arr[i];
            int leftRest = leftSum - i * avg;
            int rightRest = (sum - cur - leftSum) - (l - 1 - i) * avg;
            int move = 0;
            if (leftRest < 0 && rightRest < 0) {
                move = Math.abs(leftRest + rightRest);
            } else {
                move = Math.max(Math.abs(leftRest), Math.abs(rightRest));
            }
            result = Math.max(result, move);
            leftSum += cur;
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{0, 0, 11, 5};
        int move = solution(arr);
        System.out.println(move);
    }
}
