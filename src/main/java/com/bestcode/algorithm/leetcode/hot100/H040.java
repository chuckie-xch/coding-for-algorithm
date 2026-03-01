package com.bestcode.algorithm.leetcode.hot100;

import com.bestcode.algorithm.util.TreeNode;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/11/30 5:28 PM
 **/
public class H040 {

    /**
     * 101. 对称二叉树
     * <p>
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     * <p>
     * 提示：
     * <p>
     * 树中节点数目在范围 [1, 1000] 内
     * -100 <= Node.val <= 100
     * <p>
     * https://leetcode.cn/problems/symmetric-tree/
     *
     * @param root
     * @return
     */
    public static boolean solution(TreeNode root) {
        return check(root, root);
    }

    private static boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}
