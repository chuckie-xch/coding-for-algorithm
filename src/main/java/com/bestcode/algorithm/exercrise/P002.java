package com.bestcode.algorithm.exercrise;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/9/16 4:08 PM
 **/
public class P002 {

    /**
     * 一个数组中只有两种字符"G"和"B"，
     * 想让所有的G都放在左侧，所有的B都放在右侧 或者 让B都放在左侧，G都放在右侧
     * 但是只能在相邻字符之间进行交换操作，返回至少需要多少次交换
     */
    public static int solution(char[] arr) {
        int step1 = 0;
        int gi = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'G') {
                step1 += i - (gi++);
            }
        }
        int step2 = 0;
        int bi = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'B') {
                step2 += i - (bi++);
            }
        }
        return Math.min(step1, step2);
    }

    public static String randomString(int maxLen) {
        char[] str = new char[(int) (Math.random() * maxLen)];
        for (int i = 0; i < str.length; i++) {
            str[i] = Math.random() < 0.5 ? 'G' : 'B';
        }
        return String.valueOf(str);
    }


}
