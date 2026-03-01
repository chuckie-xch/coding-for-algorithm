package com.bestcode.algorithm.leetcode.hot100;

import com.bestcode.algorithm.util.TreeNode;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/11/30 9:50 AM
 **/
public class H039 {

    private static long pre = Long.MIN_VALUE;

    static class Info {
        Integer max;
        Integer min;
        boolean valid;

        public Info(Integer lMax, Integer rMin, boolean valid) {
            this.max = lMax;
            this.min = rMin;
            this.valid = valid;
        }
    }

    /**
     * 98. 验证二叉搜索树
     * <p>
     * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
     * <p>
     * 有效 二叉搜索树定义如下：
     * <p>
     * 节点的左子树只包含 小于 当前节点的数。
     * 节点的右子树只包含 大于 当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     * <p>
     * https://leetcode.cn/problems/validate-binary-search-tree/
     *
     * @param root
     * @return
     */
    public static boolean solution(TreeNode root) {
        Info info = process(root);
        return info.valid;
    }

    public static boolean solution2(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!solution2(root.left)) {
            return false;
        }
        if (pre >= root.val) {
            return false;
        }
        pre = root.val;
        return solution2(root.right);
    }

    private static Info process(TreeNode root) {
        if (root == null) {
            return null;
        }
        Info left = process(root.left);
        Info right = process(root.right);

        int min = root.val;
        int max = root.val;
        boolean leftValid = true;
        boolean rightValid = true;

        if (left != null) {
            max = Math.max(max, left.max);
            min = Math.min(min, left.min);
            leftValid = left.valid;
        }

        if (right != null) {
            max = Math.max(max, right.max);
            min = Math.min(min, right.min);
            rightValid = right.valid;
        }
        boolean valid = leftValid && rightValid && (left != null ? left.max < root.val : true) && (right != null ? right.min > root.val : true);
        return new Info(max, min, valid);
    }
}
