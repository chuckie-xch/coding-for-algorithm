package com.bestcode.algorithm.leetcode.hot100;

import com.bestcode.algorithm.util.TreeNode;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/11/30 8:04 PM
 **/
public class H046 {

    private static int sum = Integer.MIN_VALUE;

    /**
     * 124. 二叉树中的最大路径和
     * <p>
     * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
     * <p>
     * 路径和 是路径中各节点值的总和。
     * <p>
     * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
     * <p>
     * 树中节点数目范围是 [1, 3 * 104]
     * -1000 <= Node.val <= 1000
     * <p>
     * https://leetcode.cn/problems/binary-tree-maximum-path-sum/
     *
     * @param root
     * @return
     */
    public static int solution(TreeNode root) {
        maxGain(root);
        return sum;
    }

    private static int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftGain = Math.max(maxGain(root.left), 0);
        int rightGain = Math.max(maxGain(root.right), 0);
        sum = Math.max(sum, root.val + leftGain + rightGain);
        return root.val + Math.max(leftGain, rightGain);
    }


}
