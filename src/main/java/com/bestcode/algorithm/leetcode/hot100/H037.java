package com.bestcode.algorithm.leetcode.hot100;

import com.bestcode.algorithm.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/11/30 9:24 AM
 **/
public class H037 {


    /**
     * 94. 二叉树的中序遍历
     * <p>
     * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
     * <p>
     * https://leetcode.cn/problems/binary-tree-inorder-traversal/
     *
     * @param root
     * @return
     */
    public static List<Integer> solution(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        f(result, root);
        return result;
    }

    private static void f(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        f(result, root.left);
        result.add(root.val);
        f(result, root.right);
    }


}
