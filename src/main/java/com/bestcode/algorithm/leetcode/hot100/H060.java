package com.bestcode.algorithm.leetcode.hot100;

import com.bestcode.algorithm.util.ListNode;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/2 5:29 PM
 **/
public class H060 {

    /**
     * 206. 反转链表
     * <p>
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     * <p>
     * 提示：
     * <p>
     * 链表中节点的数目范围是 [0, 5000]
     * -5000 <= Node.val <= 5000
     * <p>
     * https://leetcode.cn/problems/reverse-linked-list/
     *
     * @param head
     * @return
     */
    public static ListNode solution(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
