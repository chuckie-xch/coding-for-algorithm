package com.bestcode.algorithm.leetcode.hot100;

import com.bestcode.algorithm.util.ListNode;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/12/1 12:13 PM
 **/
public class H050 {

    /**
     * 141. 环形链表
     * <p>
     * 给你一个链表的头节点 head ，判断链表中是否有环。
     * <p>
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
     * <p>
     * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
     * <p>
     * 提示：
     * <p>
     * 链表中节点的数目范围是 [0, 104]
     * -105 <= Node.val <= 105
     * pos 为 -1 或者链表中的一个 有效索引 。
     * <p>
     * https://leetcode.cn/problems/linked-list-cycle/
     *
     * @param head
     * @return
     */
    public static boolean solution(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
