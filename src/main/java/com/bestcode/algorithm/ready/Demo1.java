package com.bestcode.algorithm.ready;

import com.bestcode.algorithm.util.ListNode;

import java.util.Arrays;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/2 2:00 PM
 **/
public class Demo1 {


    public static void main(String[] args) {
//        String s = new String();
//        int[] arr = new int[233];
//        s.substring(2);

        convert("PAYPALISHIRING", 3);
    }


    public static String convert(String s, int numRows) {

        int len = s.length();
        if(len <= numRows) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numRows; i++) {
            boolean down = (i != numRows - 1) ? true : false;
            for(int j = i; j < len; ) {
                sb.append(s.charAt(j));
                int step = down ? (numRows - 1 - i) * 2 : i * 2;
                j += step;
                down = !down;
            }
        }

        return sb.toString();
    }

    public static ListNode solution2(ListNode head) {
        int length = getLength(head);
        if (length == 0 || length == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        for (int subLength = 1; subLength <= length; subLength <<= 1) {
            ListNode pre = dummy;
            ListNode cur = dummy.next;
            while (cur != null) {
                ListNode head1 = cur;
                for (int i = 1; i < subLength && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode head2 = cur.next;
                cur.next = null;
                cur = head2;
                for (int i = 1; i < subLength && cur != null && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode next = null;
                if (cur != null) {
                    next = cur.next;
                    cur.next = null;
                }

                ListNode sortedList = mergeList(head1, head2);
                pre.next = sortedList;
                while (pre.next != null) {
                    pre = pre.next;
                }

                cur = next;
            }
        }
        return dummy.next;
    }

    private static int getLength(ListNode head) {
        ListNode node = head;
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }


    private static ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        return mergeList(list1, list2);
    }


    public static ListNode mergeList(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        ListNode p1 = head1;
        ListNode p2 = head2;
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
