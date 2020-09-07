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
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        Integer c;
        List<Integer> aa = new LinkedList<>();
        head =niukeJianzhiOffer.ReverseList(head);
        System.out.println(head.val);
    }
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
}
