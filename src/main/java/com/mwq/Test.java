package com.mwq;



import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @author mwq0106
 * @date 2020/9/23
 */
public class Test {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    /**
     * psvm sout快捷键
     * @param args
     */
    public static void main(String[] args) {
        Test test=new Test();
        int[] nums = new int[]{4,2,0,3,2,5};
        List<Integer> list=new ArrayList<>();
        int res = test.largestRectangleArea(nums);
        System.out.println(res);
    }
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max=0;
        for(int i=0;i<heights.length;i++){
            if(stack.isEmpty() || heights[stack.peek()]<=heights[i]){
                stack.push(i);
                continue;
            }else {
                while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                    int index = stack.pop();
                    while(!stack.isEmpty() && heights[stack.peek()] == heights[index]){
                        index = stack.pop();
                    }
                    if(!stack.isEmpty()){
                        int temp = (i- stack.peek() -1)*heights[index];
                        if(temp > max){
                            max = temp;
                        }
                    }else {
                        int temp = i*heights[index];
                        if(temp > max){
                            max = temp;
                        }
                    }
                }
                stack.push(i);
            }
        }
        while(!stack.isEmpty()){
            int temp = stack.pop();
            int width;
            if(stack.isEmpty()){
                width = heights.length;
            }else {
                width = heights.length - stack.peek()-1;
            }
            max = Math.max(width*heights[temp],max);
        }
        return max;
    }
    public int largestRectangleArea2(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }

        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>(len);
        for (int i = 0; i < len; i++) {
            // 这个 while 很关键，因为有可能不止一个柱形的最大宽度可以被计算出来
            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                    stack.pollLast();
                }

                int curWidth;
                if (stack.isEmpty()) {
                    curWidth = i;
                } else {
                    curWidth = i - stack.peekLast() - 1;
                }

                // System.out.println("curIndex = " + curIndex + " " + curHeight * curWidth);
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }

        while (!stack.isEmpty()) {
            int curHeight = heights[stack.pollLast()];
            while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                stack.pollLast();
            }
            int curWidth;
            if (stack.isEmpty()) {
                curWidth = len;
            } else {
                curWidth = len - stack.peekLast() - 1;
            }
            res = Math.max(res, curHeight * curWidth);
        }
        return res;
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }
        ListNode slow=head,fast=head.next;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode rightHead=slow.next;
        slow.next=null;
        ListNode pre=rightHead;
        ListNode currentNode=rightHead.next;
        rightHead.next=null;
        while(currentNode!=null){
            ListNode temp=currentNode.next;
            currentNode.next=pre;
            pre=currentNode;
            currentNode=temp;
            if(currentNode==null){
                rightHead=pre;
            }
        }
        currentNode =rightHead;
        ListNode leftNode=head;
        while(currentNode!=null){
            if(leftNode.val!=currentNode.val){
                return false;
            }
            currentNode=currentNode.next;
            leftNode=leftNode.next;
        }
        return true;
    }
}
