package com.bestcode.algorithm.basic.list;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/9/8 3:43 PM
 **/
public class ReverseList {

    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static DoubleNode reverseDoubleNode(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }



    public static class Node {

        public int value;

        private Node next;

        public Node(int value, Node next) {
            this.next = next;
            this.value = value;
        }
    }

    public static class DoubleNode {

        public int value;

        private DoubleNode next;

        private DoubleNode pre;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

}
