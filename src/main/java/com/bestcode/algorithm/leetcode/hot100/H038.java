package com.bestcode.algorithm.leetcode.hot100;

import com.bestcode.algorithm.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/11/30 9:46 AM
 **/
public class H038 {

    private static long pre = Long.MIN_VALUE;

    /**
     * 95. 不同的二叉搜索树 II
     * <p>
     * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
     * <p>
     * https://leetcode.cn/problems/unique-binary-search-trees-ii/
     *
     * @param n
     * @return
     */
    public static List<TreeNode> solution(int n) {
        List<TreeNode> result = generateTree(1, n);
        return result;
    }

    /**
     * 96. 不同的二叉搜索树
     * <p>
     * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
     * <p>
     * https://leetcode.cn/problems/unique-binary-search-trees/
     *
     * @param n
     * @return
     */
    public static int solution1(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }


    private static List<TreeNode> generateTree(int begin, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (begin > end) {
            result.add(null);
            return result;
        }
        for (int i = begin; i <= end; i++) {
            List<TreeNode> leftNodes = generateTree(begin, i - 1);
            List<TreeNode> rightNodes = generateTree(i + 1, end);
            for (TreeNode left : leftNodes) {
                for (TreeNode right : rightNodes) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = left;
                    cur.right = right;
                    result.add(cur);
                }
            }
        }
        return result;
    }


}
