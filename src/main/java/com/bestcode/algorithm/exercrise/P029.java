package com.bestcode.algorithm.exercrise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/10/19 4:44 PM
 **/
public class P029 {

    /**
     * 设计并实现LRU数据结构
     * https://leetcode.cn/problems/lru-cache/
     */
    public static class LruCache<K,V> {

        private Map<K, Node<K,V>> map;

        private NodeDoubleLinkedList<K,V> nodeList;
        private int capacity;

        public LruCache(int capacity) {
            this.capacity = capacity;
            nodeList = new NodeDoubleLinkedList<>();
            map = new HashMap<>();
        }

        public V get(K key) {
            if (map.containsKey(key)) {
                Node<K, V> node = map.get(key);
                nodeList.moveNodeToTail(node);
                return node.v;
            }
            return null;
        }

        public void put(K key, V value) {
            if (map.containsKey(key)) {
                Node<K, V> node = map.get(key);
                node.v = value;
                nodeList.moveNodeToTail(node);
            } else {
                Node node = new Node(key, value);
                nodeList.addNode(node);
                map.put(key, node);
                if (map.size() == capacity + 1) {
                    removeMostUnusedCache();
                }
            }
        }

        private void removeMostUnusedCache() {
            Node<K, V> node = nodeList.removeHead();
            map.remove(node.k);
        }

    }

    public static class Node<K,V> {

        private K k;
        private V v;

        private Node<K,V> last;

        private Node<K,V> next;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }

    public static class NodeDoubleLinkedList<K,V> {

        private Node<K,V> head;

        private Node<K,V> tail;

        public NodeDoubleLinkedList() {
            head = null;
            tail = null;
        }

        public void addNode(Node<K, V> node) {
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                node.last = tail;
                tail = node;
            }
        }

        public void moveNodeToTail(Node<K, V> node) {
            if (node == tail) {
                return;
            }
            if (node == head) {
                head = node.next;
                head.last = null;
            } else {
                node.last.next = node.next;
                node.next.last = node.last;
            }
            tail.next = node;
            node.last = tail;
            node.next = null;
            tail = node;
        }

        public Node<K, V> removeHead() {
            if (head == null) {
                return null;
            }
            Node<K,V> node = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = node.next;
                node.next = null;
                head.last = null;
            }
            return node;
        }

    }
}
