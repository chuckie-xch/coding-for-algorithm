package com.bestcode.algorithm.exercrise;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/10/11 5:48 PM
 **/
public class P014 {

    /**
     * 给定一个字符串表示一个公式，
     * 公式里可能有整数、加减乘除符号和左右括号
     * 返回公式的计算结果
     * 说明：
     * 1. 可以认为给定的字符串一定是正确的公式
     * 2. 如果是负数，就要用括号括起来比如：4*(-3), 但如果负数作为公式的开头或者括号部分的开头，则可以没有括号，比如："-3*4" 和 (-3*4)
     * 都是合法的
     * 3. 不用考虑计算过程中会发生溢出的情况
     *
     * @param str
     * @return
     */
    public static int solution(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] arr = str.toCharArray();
        return f(arr, 0)[0];
    }

    public static void main(String[] args) {
        int result = solution("3/2");
        System.out.println(result);
    }

    private static int[] f(char[] arr, int i) {
        LinkedList<String> que = new LinkedList<>();
        int num = 0;
        while (i < arr.length && arr[i] != ')') {
            if (isNum(arr[i])) {
                num = num * 10 + (arr[i] - '0');
                i++;
            } else if (arr[i] != '(') {
                addNum(que, num);
                que.addLast(String.valueOf(arr[i++]));
                num = 0;
            } else {
                int[] result = f(arr, i + 1);
                num = result[0];
                i = result[1] + 1;
            }
        }
        addNum(que, num);
        int result = getNum(que);
        return new int[]{result, i};
    }

    private static int getNum(LinkedList<String> que) {
        int result = 0;
        boolean add = true;
        while (!que.isEmpty()) {
            String cur = que.pollFirst();
            if (cur.equals("+")) {
                add = true;
            } else if (cur.equals("-")) {
                add = false;
            } else {
                result = add ? result + Integer.valueOf(cur) : result - Integer.valueOf(cur);
            }
        }
        return result;
    }


    private static void addNum(LinkedList<String> que, int num) {
        if (!que.isEmpty()) {
            String top = que.pollLast();
            if (top.equals("+") || top.equals("-")) {
                que.addLast(top);
            } else {
                int cur = Integer.valueOf(que.pollLast());
                num = top.equals("*") ? (num * cur) : (cur / num);
            }
        }
        que.addLast(String.valueOf(num));
    }

    private static boolean isNum(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }
}
