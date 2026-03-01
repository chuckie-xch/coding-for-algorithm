package com.bestcode.algorithm.leetcode.hot100;

import com.bestcode.algorithm.util.ListNode;

import java.util.List;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/11/26 6:28 PM
 **/
public class H014 {


    /**
     * 23. 合并K个升序链表
     * 给你一个链表数组，每个链表都已经按升序排列。
     * <p>
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     * <p>
     * https://leetcode.cn/problems/merge-k-sorted-lists/?favorite=2cktkvj
     *
     * @param lists
     * @return
     */
    public static ListNode solution(ListNode[]  lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private static ListNode merge(ListNode[]  lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int middle = l + ((r - l) >> 1);
        return mergeTwoNode(merge(lists, l, middle), merge(lists, middle + 1, r));
    }

    private static ListNode mergeTwoNode(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        ListNode dummy = new ListNode();
        ListNode tail = dummy, p1 = list1, p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                tail.next = p1;
                p1 = p1.next;
            } else {
                tail.next = p2;
                p2 = p2.next;
            }
            tail = tail.next;
        }
        tail.next = p1 == null ? p2 : p1;
        return dummy.next;
    }
}
