package com.bestcode.algorithm.leetcode.hot100;

import com.bestcode.algorithm.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/8 6:19 PM
 **/
public class H088 {

    /**
     * 437. 路径总和 III
     * <p>
     * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
     * <p>
     * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
     * <p>
     * https://leetcode.cn/problems/path-sum-iii/
     *
     * @param root
     * @param targetSum
     * @return
     */
    public static int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        ans += dfs(root, targetSum);
        ans += pathSum(root.left, targetSum);
        ans += pathSum(root.right, targetSum);
        return ans;
    }


    public static int pathSum2(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1);
        int cnt = backTracking(root, prefixSumCount, targetSum, 0L);
        return cnt;
    }

    private static int backTracking(TreeNode root, Map<Long, Integer> prefixSumCount, int target, long sum) {
        int ans = 0;
        if (root == null) {
            return 0;
        }
        sum += root.val;
        if (prefixSumCount.containsKey(sum - target)) {
            ans += prefixSumCount.get(sum - target);
        }
        prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        ans += backTracking(root.left, prefixSumCount, target, sum);
        ans += backTracking(root.right, prefixSumCount, target, sum);
        prefixSumCount.put(sum, prefixSumCount.get(sum) - 1);
        return ans;
    }

    private static int dfs(TreeNode root, long target) {
        int ans = 0;
        if (root == null) {
            return 0;
        }
        if (target == root.val) {
            ans++;
        }
        ans += dfs(root.left, target - root.val);
        ans += dfs(root.right, target - root.val);
        return ans;
    }
}
