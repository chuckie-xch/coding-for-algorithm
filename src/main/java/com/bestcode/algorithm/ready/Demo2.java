package com.bestcode.algorithm.ready;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/8 2:04 PM
 **/
public class Demo2 {


    public static String longestPalindrome(String s) {
        int n = s.length();
        char[] arr = manacherString(s);
        int[] radius = new int[arr.length];
        int center = -1;
        int right = -1;
        int maxLen = 0;
        int maxIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            radius[i] = right > i ? Math.min(right - i, radius[2 * center - i]) : 1;
            while (i + radius[i] < arr.length && i - radius[i] >= 0) {
                if (arr[i + radius[i]] == arr[i - radius[i]]) {
                    radius[i]++;
                } else {
                    break;
                }
            }
            if (i + radius[i] > right) {
                right = i + radius[i];
                center = i;
            }
            if (radius[i] > maxLen) {
                maxLen = radius[i];
                maxIndex = i;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = maxIndex - maxLen + 1; i <= maxIndex + maxLen - 1; i++) {
            if (arr[i] != '#') {
                sb.append(arr[i]);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
       String s = longestPalindrome("babad");
        System.out.println(s);
    }

    private static char[] manacherString(String s) {
        int n = s.length();
        char[] arr = new char[n * 2 + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((i & 1) == 0) {
                arr[i] = '#';
            } else {
                arr[i] = s.charAt(index++);
            }
        }
        return arr;
    }


}
