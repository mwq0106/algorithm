package com.mwq;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author mwq0106
 * @date 2020/9/4
 */
public class NiukeJianzhiOffer {


    public static void main(String[] ar){

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

    public static void print(int[][] numbs){
        int a = 0,b = numbs[0].length-1;//左右
        int c = 0,d = numbs.length-1;//上下
        int de = 0;
        int i = 0;
        int j = 0;
        while (true){
//            while (j<=b){
//                System.out.print(numbs[i][j]);
//                j++;
//            }
//            j--;
//            i++;
//            c ++;
//            de = 1;
//
//            while (i <= d){
//                System.out.print(numbs[i][j]);
//                i ++;
//            }
//            i--;
//            j--;
//            b --;
//            de = 2;
//
//            while (j >= a){
//                System.out.print(numbs[i][j]);
//                j --;
//            }
//            j++;
//            i--;
//            d --;
//            de = 3;
//
//            while (i>=c){
//                System.out.print(numbs[i][j]);
//                i--;
//            }
//            i++;
//            j++;
//            a ++;
//            de = 0;

            if(de == 0){
                while (j<=b){
                    System.out.print(numbs[i][j]+" ");
                    j++;
                }
                j--;
                i++;
                c ++;
                de = 1;
            }else if(de == 1){
                while (i <= d){
                    System.out.print(numbs[i][j]+" ");
                    i ++;
                }
                i--;
                j--;
                b --;
                de = 2;
            }else if(de == 2){
                while (j >= a){
                    System.out.print(numbs[i][j]+" ");
                    j --;
                }
                j++;
                i--;
                d --;
                de = 3;
            }else {
                while (i>=c){
                    System.out.print(numbs[i][j]+" ");
                    i--;
                }
                i++;
                j++;
                a ++;
                de = 0;
            }
            if(c>d || a>b){
                break;
            }
        }

    }



}
