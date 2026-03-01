package com.bestcode.algorithm.leetcode.hot100;

import java.util.List;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/11/26 5:12 PM
 **/
public class H012 {

    /**
     * 21. 合并两个有序链表
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * <p>
     * https://leetcode.cn/problems/merge-two-sorted-lists/?favorite=2cktkvj
     *
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode solution(ListNode list1, ListNode list2) {
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

    public static ListNode solution1(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                cur.next = p1;
                p1 = p1.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }
        while (p1 != null) {
            cur.next = p1;
            cur = cur.next;
            p1 = p1.next;
        }
        while (p2 != null) {
            cur.next = p2;
            cur = cur.next;
            p2 = p2.next;
        }
        return dummy.next;
    }



    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode() {
        }
    }
}
