package com.bestcode.algorithm.leetcode.hot100;

import com.bestcode.algorithm.util.ListNode;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/3 1:52 PM
 **/
public class H066 {

    /**
     * 234. 回文链表
     * <p>
     * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
     * <p>
     * https://leetcode.cn/problems/palindrome-linked-list/
     * <p>
     * 提示：
     * <p>
     * 链表中节点数目在范围[1, 105] 内
     * 0 <= Node.val <= 9
     *
     * @param head
     * @return
     */
    public static boolean solution(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head1 = head;
        ListNode head2 = slow.next;
        slow.next = null;

        head2 = reverseList(head2);

        boolean result = true;
        while ( head1 != null && head2 != null) {
            if (head1.val != head2.val) {
                result = false;
                break;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        slow.next = reverseList(head2);
        return result;
    }

    private static ListNode reverseList(ListNode root) {
        ListNode pre = null;
        ListNode cur = root;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
