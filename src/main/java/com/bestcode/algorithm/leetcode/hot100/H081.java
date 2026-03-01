package com.bestcode.algorithm.leetcode.hot100;

import com.bestcode.algorithm.util.TreeNode;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/6 6:46 PM
 **/
public class H081 {

    private static int ans = Integer.MIN_VALUE;

    /**
     * 337. 打家劫舍 III
     * <p>
     * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
     * <p>
     * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
     * <p>
     * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
     * <p>
     * https://leetcode.cn/problems/house-robber-iii/
     *
     * @param root
     * @return
     */
    public static int solution(TreeNode root) {
        int[] ans = process(root);
        return Math.max(ans[0], ans[1]);
    }

    private static int[] process(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = process(root.left);
        int[] right = process(root.right);
        int steal = left[1] + root.val + right[1];
        int noSteal = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{steal, noSteal};
    }
}
