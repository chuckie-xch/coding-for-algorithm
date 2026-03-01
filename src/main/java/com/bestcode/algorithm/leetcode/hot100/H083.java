package com.bestcode.algorithm.leetcode.hot100;

import java.util.*;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/6 7:24 PM
 **/
public class H083 {

    /**
     * 347. 前 K 个高频元素
     * <p>
     * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
     * <p>
     * https://leetcode.cn/problems/top-k-frequent-elements/
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] solution(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int key = nums[i];
            int count = map.containsKey(key) ? map.get(key) + 1 : 1;
            map.put(key, count);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer count = entry.getValue();
            if (queue.size() < k) {
                queue.offer(new int[]{key, count});
            } else if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{key, count});
                }
            }
        }
        int[] ans = new int[k];
        int index = 0;
        while (!queue.isEmpty()) {
            ans[index++] = queue.poll()[0];
        }
        return ans;
    }

    public static int[] solution2(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int key = nums[i];
            int count = map.containsKey(key) ? map.get(key) + 1 : 1;
            map.put(key, count);
        }
        List<Integer> res = new ArrayList<>();
        List<Integer>[] count = new List[len + 1];
        for (int key : map.keySet()) {
            int i = map.get(key);
            if (count[i] == null) {
                count[i] = new ArrayList<>();
            }
            count[i].add(key);
        }

        for (int i = count.length - 1; i >= 1 && res.size() < k; i--) {
            if (count[i] != null) {
                res.addAll(count[i]);
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }


}
