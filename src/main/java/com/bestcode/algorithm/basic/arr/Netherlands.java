package com.bestcode.algorithm.basic.arr;

import com.bestcode.algorithm.basic.util.ArrayUtil;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/9/13 6:23 PM
 **/
public class Netherlands {


    /**
     * 以数组arr[r]的值为比较数，小于arr[r]的数放到数组左边，等于arr[r]的数放到中间，大于arr[r]的数放到右边，返回等于区域的左右边界
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    public static int[] netherlands(int[] arr, int l, int r) {
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
