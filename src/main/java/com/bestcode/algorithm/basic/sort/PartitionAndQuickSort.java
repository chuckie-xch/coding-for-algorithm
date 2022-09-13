package com.bestcode.algorithm.basic.sort;

import com.bestcode.algorithm.basic.util.ArrayUtil;

import java.lang.reflect.Array;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/9/13 6:46 PM
 **/
public class PartitionAndQuickSort {


    public static void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int l, int r) {
        if (l > r) {
            return;
        }
        ArrayUtil.swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
        int[] area = netherlandsFlag(arr, l, r);
        process(arr, l, area[0] - 1);
        process(arr, area[1] + 1, r);
    }

    public static int[] netherlandsFlag(int[] arr, int l, int r) {
        if (l > r) {
            return new int[]{-1, -1};
        }
        if (l == r) {
            return new int[]{l, r};
        }
        int less = l - 1;
        int more = r;
        int index = l;
        while (index < more) {
            if (arr[index] == arr[r]) {
                index++;
            } else if (arr[index] < arr[r]) {
                ArrayUtil.swap(arr, index++, ++less);
            } else {
                ArrayUtil.swap(arr, index, --more);
            }
        }
        ArrayUtil.swap(arr, more, r);
        return new int[]{less + 1, more};
    }
}
