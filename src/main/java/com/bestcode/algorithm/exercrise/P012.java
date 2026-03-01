package com.bestcode.algorithm.exercrise;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author chunhang.xch
 * @Description
 * @date 2022/10/11 11:23 AM
 **/
public class P012 {

    private static final MessageDigest hash;

    static {
        try {
            hash = MessageDigest.getInstance("SHA-256");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static class Node {
        int value;

        Node left;

        Node right;
    }

    /**
     * 如果一个节点X，它左树结构和右树结构完全一样，那么我们说以X为头的子树是相等子树
     * 给定一棵二叉树的头节点head，返回head整棵树上有多少棵相等子树
     *
     * @param head
     * @return
     */
    public static int solution(Node head) {
        if (head == null) {
            return 0;
        }
        Info info = process(head);
        return info.sameNum;
    }

    private static Info process(Node node) {
        if (node == null) {
            return new Info(0, genHash("#,"));
        }
        Info left = process(node.left);
        Info right = process(node.right);
        int sameNum = left.sameNum + right.sameNum + (left.hash.equals(right.hash) ? 1 : 0);
        String hash = genHash(node.value + "," + left.hash + right.hash);
        return new Info(sameNum, hash);
    }

    private static String genHash(String s) {
        return DatatypeConverter.printHexBinary(hash.digest(s.getBytes())).toUpperCase();
    }


    public static class Info {

        int sameNum;

        String hash;

        public Info(int num, String hash) {
            this.hash = hash;
            this.sameNum = num;
        }
    }
}
