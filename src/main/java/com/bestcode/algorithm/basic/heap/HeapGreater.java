package com.bestcode.algorithm.basic.heap;

import java.util.*;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/9/15 5:26 PM
 **/
public class HeapGreater<T> {

    private List<T> heap;

    private Map<T, Integer> indexMap;

    private int heapSize;

    private Comparator<? super T> comparator;

    public HeapGreater(Comparator<? super T> comparator) {
        this.comparator = comparator;
        heapSize = 0;
        heap = new ArrayList<>();
        indexMap = new HashMap<>();
    }

    public void push(T value) {
        heap.add(value);
        indexMap.put(value, heapSize);
        heapInsert(heapSize++);
    }

    public T pop() {
        T t = heap.get(0);
        swap(0, heapSize - 1);
        indexMap.remove(t);
        heap.remove(--heapSize);
        heapify(0);
        return t;
    }

    private void heapify(int index) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && comparator.compare(heap.get(left + 1), heap.get(left)) < 0 ? left + 1 : left;
            largest = comparator.compare(heap.get(index), heap.get(largest)) < 0 ? index : largest;
            if (largest == index) {
                break;
            }
            swap(index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public void resign(T t) {
        heapInsert(indexMap.get(t));
        heapify(indexMap.get(t));
    }

    private void heapInsert(int index) {
        while (comparator.compare(heap.get(index), heap.get((index - 1) / 2)) < 0) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private void swap(int i, int j) {
        T t = heap.get(i);
        T t1 = heap.get(j);
        heap.set(i, t1);
        heap.set(j, t);
        indexMap.put(t, j);
        indexMap.put(t1, i);

    }
}
