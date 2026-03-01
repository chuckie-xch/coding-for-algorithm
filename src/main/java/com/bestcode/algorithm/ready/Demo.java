package com.bestcode.algorithm.ready;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/11/23 9:42 AM
 **/
public class Demo {

    public static class Node {
        public int value;
        private Node next;

        private Node pre;
    }

    public static void main(String[] args) {

        char[] arr1 = "ABCDE".toCharArray();
        char[] arr2 = "12345".toCharArray();

        final Object o = new Object();
        final CountDownLatch countDown = new CountDownLatch(1);
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

        new Thread(() -> {
            try {
                countDown.await();
            } catch (Throwable e) {
                e.printStackTrace();
            }
            lock.lock();
            try {
                for (char c : arr1) {
                    System.out.println(c);
                    condition2.signal();
                    condition1.await();
                }
                condition2.signal();
            } catch (Throwable e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t1").start();

        new Thread(() -> {
            lock.lock();
            try {
                for (char c : arr2) {
                    System.out.println(c);
                    countDown.countDown();
                    condition1.signal();
                    condition2.await();
                }
                condition1.signal();
            } catch (Throwable e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t2").start();
    }

    public static Node reverseNode(Node head) {
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

    public static Node reverseDoubleNode(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void solution(int[] arr) {
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int l, int r) {
        if (l > r) {
            return;
        }
        int random = l + (int) (Math.random() * (r - l + 1));
        swap(arr, random, r);
        int[] area = netherlandsFlag(arr, l, r);
        process(arr, l, area[0] - 1);
        process(arr, area[1] + 1, r);
    }

    public static int[] netherlandsFlag(int[] arr, int l, int r) {
        if (l > r) {
            return new int[]{-1, -1};
        }
        if (l == r) {
            return new int[]{l, r};
        }
        int less = l - 1;
        int more = r;
        int index = l;
        while (index < more) {
            if (arr[index] == arr[r]) {
                index++;
            } else if (arr[index] < arr[r]) {
                swap(arr, index++, ++less);
            } else {
                swap(arr, index, --more);
            }
        }
        swap(arr, more, r);
        return new int[]{less + 1, more};
    }

    public static void merge(int[] arr, int l, int middle, int r) {
        int[] help = new int[r - l + 1];

        int left = l;
        int right = middle + 1;

        int index = 0;
        while (left <= middle && right <= r) {
            help[index++] = arr[left] < arr[right] ? arr[left++] : arr[right++];
        }

        while (left <= middle) {
            help[index++] = arr[left++];
        }

        while (right <= r) {
            help[index++] = arr[right++];
        }


        for (int i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
