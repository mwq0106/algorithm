package com.mwq;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author mwq0106
 * @date 2020/9/4
 */
public class NiukeJianzhiOffer {
    @Test
    public void duplicate(int numbers[],int length,int [] duplication) {

    }
    public static void main(String[] a) throws Exception{
        NiukeJianzhiOffer niukeJianzhiOffer = new NiukeJianzhiOffer();
        List<Node> list = new LinkedList<>();
        Node node = new Node();
        node.val =1;
        list.add(node);
        Node node2 = new Node();
        node2.val =2;
        list.add(node2);
        list.add(null);
        list.add(null);
        Node node3 = new Node();
        node3.val =3;
        list.add(node3);
        list.add(null);
        list.add(null);
        niukeJianzhiOffer.list = list;
        niukeJianzhiOffer.l = 0;
        niukeJianzhiOffer.r = list.size()-1;
        Node root = niukeJianzhiOffer.de();
    }

    /**
     * 翻转链表，注意头节点的next要弄成null,不然会形成环
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        ListNode pre = head;
        ListNode node = head.next;
        while(node != null){
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
    public static class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}


    private List<Node> list;
    int l;
    int r;

    /**
     * 反序列化二叉树，类变量：序列化后的二叉树数组，
     * 左变量，代表用到的二叉树数组左边的索引，从左往右用，递归实现，一直往左走
     * @return
     */
    public Node de(){
        if(list.get(l) == null){
            l++;
            return null;
        }
        Node root = new Node();
        root.val = list.get(l).val;
        l++;
        root.left = de();
        root.right = de();
        return root;
    }
    public static class Node {
        Node left;
        Node right;
        int val;
    }
}
