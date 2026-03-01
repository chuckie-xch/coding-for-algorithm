package com.bestcode.algorithm.leetcode.hot100;

import com.bestcode.algorithm.util.TreeNode;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/9 2:16 PM
 **/
public class H093 {

    private static int sum = 0;

    /**
     * 538. 把二叉搜索树转换为累加树
     * <p>
     * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
     * <p>
     * 提醒一下，二叉搜索树满足下列约束条件：
     * <p>
     * 节点的左子树仅包含键 小于 节点键的节点。
     * 节点的右子树仅包含键 大于 节点键的节点。
     * 左右子树也必须是二叉搜索树。
     * <p>
     * https://leetcode.cn/problems/convert-bst-to-greater-tree/
     *
     * @param root
     * @return
     */
    public static TreeNode solution(TreeNode root) {
        convertBST(root);
        return root;
    }

    private static void convertBST(TreeNode root) {
        if (root == null) {
            return;
        }
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
    }
}
