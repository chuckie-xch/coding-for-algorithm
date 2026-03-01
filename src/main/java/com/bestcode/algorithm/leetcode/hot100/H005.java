package com.bestcode.algorithm.leetcode.hot100;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/11/25 4:25 PM
 **/
public class H005 {

    /**
     * 5. 最长回文子串
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * <p>
     * https://leetcode.cn/problems/longest-palindromic-substring/
     *
     * @param s
     * @return
     */
    public static String solution(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        char[] arr = manacherString(s);
        int[] radiusArr = new int[arr.length];
        int center = -1;
        int right = -1;
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            radiusArr[i] = right > i ? Math.min(right - i, radiusArr[2 * center - i]) : 1;
            while (i + radiusArr[i] < radiusArr.length && i - radiusArr[i] > -1) {
                if (arr[i - radiusArr[i]] == arr[i + radiusArr[i]]) {
                    radiusArr[i]++;
                } else {
                    break;
                }
            }
            if (right < i + radiusArr[i]) {
                right = i + radiusArr[i];
                center = i;
            }
            if (radiusArr[i] > max) {
                max = radiusArr[i];
                maxIndex = i;
            }
        }
        char[] resultArr = new char[radiusArr[maxIndex] - 1];
        int index = 0;
        for (int i = maxIndex - max + 1; i < maxIndex + max; i++) {
            if (arr[i] != '#') {
                resultArr[index++] = arr[i];
            }
        }
        return new String(resultArr);
    }

    public static String solution2(String s) {
        int n = s.length();
        int maxLen = 1;
        int start = 0;
        int end = 1;
        boolean[][] dp = new boolean[n][n];

        for (int r = 1; r < n; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l >= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    int len = r - l + 1;
                    if (len > maxLen) {
                        maxLen = len;
                        start = l;
                        end = r;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }

    private static char[] transferString(String s) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int i = 0;

        while(i < s.length()) {
            if((index & 1) == 0) {
                sb.append("#");
            } else {
                sb.append(s.charAt(i));
                i++;
            }

            index++;
        }

        return sb.toString().toCharArray();
    }



    private static char[] manacherString(String s) {
        char[] arr = s.toCharArray();
        char[] res = new char[arr.length * 2 + 1];
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : arr[index++];
        }
        return res;
    }

    public static void main(String[] args) {
//        String s = "babad";
//        System.out.println(solution(s));

        System.out.println(transferString("bb"));
    }
}
