package com.bestcode.algorithm.exercrise;

import java.util.Arrays;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/9/16 3:04 PM
 **/
public class P001 {

    /**
     * 给定一个有序数组arr，代表坐落在X轴上的点，给定一个整数K,代表绳子的长度，返回绳子最多压中几个点？
     * 即使绳子边缘出覆盖也算盖住
     */
    public static int solution1(int[] arr, int k) {
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            int nearestIndex = nearestIndex(arr, i, arr[i] - k);
            res = Math.max(res, i - nearestIndex + 1);
        }
        return res;
    }

    public static int solution2(int[] arr, int k) {
        int l = 0;
        int r = 0;
        int res = 1;
        while (l < arr.length) {
            while (r < arr.length && arr[r] - arr[l] <= k) {
                r++;
            }
            res = Math.max(res, r - l);
            l++;
        }
        return res;
    }

    /**
     * 大于等于value的最小的位置
     *
     * @param arr
     * @param r
     * @param value
     * @return
     */
    private static int nearestIndex(int[] arr, int r, int value) {
        int l = 0;
        int index = r;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return index;
    }


    public static int[] generateArray(int len, int max) {
        int[] ans = new int[(int) (Math.random() * len) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (int) (Math.random() * max);
        }
        Arrays.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        int len = 100;
        int max = 1000;
        int testTime = 100000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int L = (int) (Math.random() * max);
            int[] arr = generateArray(len, max);
            int ans1 = solution1(arr, L);
            int ans2 = test(arr, L);
            int ans3 = solution2(arr, L);
            if (ans1 != ans2 || ans2 != ans3) {
                System.out.println("ans1 = " + ans1 + ", ans2 = " + ans2 + ",ans3 = " + ans3);
                break;
            }
        }

    }

    public static int test(int[] arr, int L) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int pre = i - 1;
            while (pre >= 0 && arr[i] - arr[pre] <= L) {
                pre--;
            }
            max = Math.max(max, i - pre);
        }
        return max;
    }
}
