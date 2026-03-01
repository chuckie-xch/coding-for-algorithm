package com.bestcode.algorithm.leetcode.hot100;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/7 8:41 PM
 **/
public class H085 {

    static class UnionFind {

        int[] parent;

        double[] weight;

        public UnionFind(int n) {
            parent = new int[n];
            weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
            weight[rootX] = (value * weight[y]) / weight[x];
        }

        public int find(int x) {
            if (parent[x] != x) {
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public double isConnected(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot == yRoot) {
                return weight[x] / weight[y];
            } else {
                return -1d;
            }
        }

    }

    /**
     * 399. 除法求值
     * <p>
     * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
     * <p>
     * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
     * <p>
     * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
     * <p>
     * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
     * <p>
     * https://leetcode.cn/problems/evaluate-division/
     *
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    public static double[] solution(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int size = equations.size() * 2;

        UnionFind unionFind = new UnionFind(size);

        Map<String, Integer> map = new HashMap<>();
        int id = 0;
        for (int i = 0; i < equations.size(); i++) {
            String var1 = equations.get(i).get(0);
            String var2 = equations.get(i).get(1);
            if (!map.containsKey(var1)) {
                map.put(var1, id);
                id++;
            }
            if (!map.containsKey(var2)) {
                map.put(var2, id);
                id++;
            }
            unionFind.union(map.get(var1), map.get(var2), values[i]);
        }

        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);
            Integer id1 = map.get(var1);
            Integer id2 = map.get(var2);
            if (id1 == null || id2 == null) {
                ans[i] = -1d;
            } else {
                ans[i] = unionFind.isConnected(id1, id2);
            }
        }

        return ans;
    }
}
