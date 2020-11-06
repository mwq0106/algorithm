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
        String temp="1";
        System.out.println(temp.substring(0,0));


        Queue<Integer> queue =new LinkedList<>();

        Test test=new Test();
        int[] nums = new int[]{0,0,1};
        List<Integer> list=new ArrayList<>();
//        test.moveZeroes(nums);
//        System.out.println(res);
    }
    public void moveZeroes(int[] nums) {
        int a=0,b=nums.length-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                continue;
            }
            for(int j=i;j<nums.length-1;j++){
                swap(nums,j,j+1);
            }
            if(nums[i]==0){
                i--;
            }
        }
    }
    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
