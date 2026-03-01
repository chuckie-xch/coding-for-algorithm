package com.bestcode.algorithm.leetcode.hot100;

import java.util.*;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/7 8:42 PM
 **/
public class H086 {

    /**
     * 406. 根据身高重建队列
     * <p>
     * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
     * <p>
     * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
     * <p>
     * https://leetcode.cn/problems/queue-reconstruction-by-height/
     *
     * @param people
     * @return
     */
    public static int[][] solution(int[][] people) {
        Arrays.sort(people, (people1, people2) -> {
            if (people1[0] != people2[0]) {
                return people2[0] - people1[0];
            } else {
                return people1[1] - people2[1];
            }
        });

        List<int[]> list = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            if (list.size() <= people[i][1]) {
                list.add(list.size(), people[i]);
            } else {
                list.add(people[i][1],people[i]);
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
