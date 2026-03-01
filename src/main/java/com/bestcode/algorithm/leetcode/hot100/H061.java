package com.bestcode.algorithm.leetcode.hot100;

import java.util.*;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/2 5:35 PM
 **/
public class H061 {

    /**
     * 207. 课程表
     * <p>
     * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
     * <p>
     * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
     * <p>
     * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
     * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
     * <p>
     * https://leetcode.cn/problems/course-schedule/
     * <p>
     * 提示：
     * <p>
     * 1 <= numCourses <= 105
     * 0 <= prerequisites.length <= 5000
     * prerequisites[i].length == 2
     * 0 <= ai, bi < numCourses
     * prerequisites[i] 中的所有课程对 互不相同
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static boolean solution(int numCourses, int[][] prerequisites) {
//        Map<Integer, Set<Integer>> dependencyMap = new HashMap<>();
//        for (int[] arr : prerequisites) {
//            int key = arr[0];
//            int val = arr[1];
//            if (dependencyMap.containsKey(key)) {
//                dependencyMap.get(key).add(val);
//            } else {
//                HashSet<Integer> set = new HashSet<>();
//                set.add(val);
//                dependencyMap.put(key, set);
//            }
//        }
//        for (int i = 0; i < numCourses; i++) {
//            if (dependencyMap.containsKey(i)) {
//                HashSet<Integer> parentSet = new HashSet<>();
//                findParent(i, i, true, dependencyMap, parentSet);
//                if (parentSet.contains(i)) {
//                    return false;
//                }
//            }
//        }
        return true;
    }

    private static void findParent(int i, int start, boolean first, Map<Integer, Set<Integer>> dependencyMap, Set<Integer> parentSet) {
        if (!dependencyMap.containsKey(i) || (!first && i == start)) {
            parentSet.add(i);
            return;
        }
        Set<Integer> parents = dependencyMap.get(i);
        for (Integer parent : parents) {
            findParent(parent, start, false, dependencyMap, parentSet);
        }
    }
}
