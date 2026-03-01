package com.bestcode.algorithm.leetcode.hot100;

import java.util.Stack;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/11/26 4:08 PM
 **/
public class H010 {


    /**
     * 19. 删除链表的倒数第 N 个结点
     * <p>
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * <p>
     * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/?favorite=2cktkvj
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode solution(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static ListNode solution2(ListNode head, int n) {
        Stack<ListNode> stack = new Stack();
        ListNode node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        if (n == stack.size()) {
            head = head.next;
            return head;
        }
        ListNode deletePre = null;
        int index = 0;
        while (index <= n && !stack.isEmpty()) {
            deletePre = stack.pop();
            index++;
        }

        deletePre.next = deletePre.next.next;
        return head;
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
