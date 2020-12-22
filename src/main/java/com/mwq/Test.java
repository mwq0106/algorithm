package com.mwq;



import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @author mwq0106
 * @date 2020/9/23
 */
public class Test {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
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

    }

    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
