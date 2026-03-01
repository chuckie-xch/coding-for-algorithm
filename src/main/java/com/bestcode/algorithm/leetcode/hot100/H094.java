package com.bestcode.algorithm.leetcode.hot100;

import com.bestcode.algorithm.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/9 2:49 PM
 **/
public class H094 {

    private static int ans = 0;

    private static Map<TreeNode, Integer> map = new HashMap<>();

    /**
     * 543. 二叉树的直径
     * <p>
     * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
     * <p>
     * https://leetcode.cn/problems/diameter-of-binary-tree/
     *
     * @param root
     * @return
     */
    public static int solution(TreeNode root) {
        process(root);
        return ans;
    }

    public static int solution2(TreeNode root) {
        depth(root);
        return ans - 1;
    }

    private static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        int res = leftDepth + rightDepth + 1;
        ans = Math.max(ans, res);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    private static void process(TreeNode root) {
        if (root == null) {
            return;
        }
        int cur = getMaxHeight(root.left) + getMaxHeight(root.right);
        ans = Math.max(ans, cur);
        process(root.left);
        process(root.right);
    }


    private static int getMaxHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int leftHeight = getMaxHeight(root.left);
        int rightHeight = getMaxHeight(root.right);
        int ans = Math.max(leftHeight, rightHeight) + 1;
        map.put(root, ans);
        return ans;
    }
}
