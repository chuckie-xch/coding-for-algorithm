package com.bestcode.algorithm.basic.heap;

import com.bestcode.algorithm.basic.util.ArrayUtil;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/9/14 3:24 PM
 **/
public class MaxHeap {

    private int[] heap;

    private int heapSize;

    private final int limit;

    public MaxHeap(int limit) {
        heap = new int[limit];
        this.limit = limit;
        heapSize = 0;
    }

    public void push(int value) {
        if (heapSize == limit) {
            throw new RuntimeException("heap is full");
        }
        heap[heapSize] = value;
        heapInsert(value, heapSize++);
    }

    private void heapInsert(int value, int index) {
        while (heap[index] > heap[(index - 1) / 2]) {
            ArrayUtil.swap(heap, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public int pop() {
        int value = heap[0];
        ArrayUtil.swap(heap, 0, --heapSize);
        heapify(heap, 0, heapSize);
        return value;
    }

    private void heapify(int[] heap, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && heap[left + 1] > heap[left] ? left + 1 : left;
            largest = heap[index] > heap[largest] ? index : largest;
            if (largest == index) {
                break;
            }
            ArrayUtil.swap(heap, index, largest);
            index = largest;
            left = 2 * index + 1;
        }
    }

    public boolean isFull() {
        return heapSize == limit;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public static class MyComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new MyComparator());
        heap.add(5);
        heap.add(5);
        heap.add(5);
        heap.add(3);
        System.out.println(heap.peek());

        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }
    }

}
