package com.bestcode.algorithm.leetcode.hot100;

import com.bestcode.algorithm.util.TreeNode;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/11/30 6:26 PM
 **/
public class H042 {


    /**
     * 104. 二叉树的最大深度
     * <p>
     * 给定一个二叉树，找出其最大深度。
     * <p>
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * <p>
     * 说明: 叶子节点是指没有子节点的节点。
     * <p>
     * https://leetcode.cn/problems/maximum-depth-of-binary-tree/
     *
     * @param root
     * @return
     */
    public static int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(solution(root.left), solution(root.right)) + 1;
    }
}
