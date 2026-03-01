package com.bestcode.algorithm.leetcode.hot100;

import com.bestcode.algorithm.util.TreeNode;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/3 1:38 PM
 **/
public class H065 {


    /**
     * 226. 翻转二叉树
     * <p>
     * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
     * <p>
     * https://leetcode.cn/problems/invert-binary-tree/
     *
     * @param root
     * @return
     */
    public static TreeNode solution(TreeNode root) {
        invertTree(root);
        return root;
    }

    public static TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = invertTree2(root.right);
        root.right = invertTree2(temp);
        return root;
    }

    private static void invertTree(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        invertTree(left);
        invertTree(right);
        root.left = right;
        root.right = left;
    }
}
