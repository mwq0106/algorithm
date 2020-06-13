package com.mwq;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author mwq0106
 * @date 2020/6/2
 */
public class JianzhiOffer {
    /**
     * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，
     * 但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
     */
    @Test
    public void repeatNumbInArray() {
        int[] numbs = new int[]{2, 3, 1, 0, 2, 5};
        int i = 0;
        while (true){
            int a = numbs[i];
            if(numbs[a] == a) {
                System.out.println(a);
                return;
            }else {
                swap(numbs,a,i);
            }
            while (numbs[i] == i){
                i++;
            }
        }
    }
    public static void swap(int[] numbs,int a,int b){
        int temp =  numbs[a];
        numbs[a] = numbs[b];
        numbs[b] = temp;
    }

    /**
     *给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
     * [
     *   [1,   4,  7, 11, 15],
     *   [2,   5,  8, 12, 19],
     *   [3,   6,  9, 16, 22],
     *   [10, 13, 14, 17, 24],
     *   [18, 21, 23, 26, 30]
     * ]
     */
    @Test
    public void arraySearch() {
        int [][] array = new int[1][];
        array[0] = new int[]{1,   4,  7, 11, 15};
        array[1] = new int[]{2,   5,  8, 12, 19};
        array[2] = new int[]{3,   6,  9, 16, 22};
        array[3] = new int[]{10, 13, 14, 17, 24};
        array[4] = new int[]{18, 21, 23, 26, 30};
        System.out.println(Find(5,array));
    }
    public boolean Find(int target, int [][] array) {
        int y = array.length;
        int x = array[0].length;
        int i = x-1;
        int j = 0;
        while (i>=0 && j<y){
            if(array[j][i] > target){
                i--;
            }else if(array[j][i] < target){
                j++;
            }else {
                return true;
            }
        }
        return false;
    }

    /**
     * 3.将一个字符串中的空格替换成 "%20"。
     * Input:
     * "A B"
     * Output:
     * "A%20B"
     */
    @Test
    public void replaceSpace(){
        StringBuffer stringBuffer = new StringBuffer("A ");
        System.out.println(replaceSpace(stringBuffer));
    }
    public String replaceSpace(StringBuffer str) {
        String s = str.toString();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(" ".toCharArray()[0] == s.charAt(i)){
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    /**
     * 4.从尾到头反过来打印出每个结点的值。
     * 1,2,3链表，打印成3,2,1
     */
    @Test
    public void printListFromTailToHead(){
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        System.out.println(printListFromTailToHead(listNode).toString());
    }
    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if(listNode == null){
            return list;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(listNode.val);
        while (listNode.next != null){
            listNode = listNode.next;
            stack.push(listNode.val);
        }
        while (!stack.empty()){
            list.add(stack.pop());
        }
        return list;
    }

}
