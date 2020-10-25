package com.mwq;



import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @author mwq0106
 * @date 2020/9/23
 */
public class Test {
    /**
     * psvm sout快捷键
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,0};
        Arrays.sort(nums,1,nums.length);
        for (int i = 0; i <26 ; i++) {
            int a = 'a';
            System.out.println((char) (a+i));
        }
        int a = 'c';
        System.out.println(a);
        Map<String,String> map = new HashMap<>();
        for(Map.Entry entry:map.entrySet()){
            System.out.println(entry.getKey());
        }
    }


}
