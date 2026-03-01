package com.bestcode.algorithm.exercrise;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/10/19 5:35 PM
 **/
public class P030 {


    public static class Node {
        private int value;

        private int arrId;

        private int index;

        public Node(int value, int arrId, int index) {
            this.value = value;
            this.arrId = arrId;
            this.index = index;
        }
    }

    public static class NodeComparator implements Comparator<Node> {

        public int compare(Node o1, Node o2) {
            return o1.value != o2.value ? o1.value - o2.value : o1.arrId - o2.arrId;
        }
    }


    /**
     * 你有 k 个 非递减排列 的整数列表。找到一个 最小 区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
     * <p>
     * 我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
     * <p>
     * https://leetcode.cn/problems/smallest-range-covering-elements-from-k-lists/
     *
     * @param nums
     * @return
     */
    public static int[] solution(List<List<Integer>> nums) {
        int arrSize = nums.size();
        TreeSet<Node> treeSet = new TreeSet<>(new NodeComparator());
        for (int i = 0; i < arrSize; i++) {
            treeSet.add(new Node(nums.get(i).get(0), i, 0));
        }
        boolean initial = true;
        int a = 0;
        int b = 0;
        while (treeSet.size() == arrSize) {
            Node minNode = treeSet.first();
            Node maxNode = treeSet.last();
            if (initial || (maxNode.value - minNode.value) < (b - a)) {
                initial = false;
                a = minNode.value;
                b = maxNode.value;
            }
            minNode = treeSet.pollFirst();
            int index = minNode.index + 1;
            if (index < nums.get(minNode.arrId).size()) {
                treeSet.add(new Node(nums.get(minNode.arrId).get(index), minNode.arrId, index));
            }
        }
        return new int[]{a, b};
    }
}
