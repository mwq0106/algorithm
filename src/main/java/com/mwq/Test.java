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
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        Map<String,List<String>> map = new HashMap<>();
        // int[][] count = new int[strs.length][];
        for(int i=0;i<strs.length;i++){
            int[] f = new int[26];
            for(int j=0;j<strs[i].length();j++){
                f[strs[i].charAt(j)-'a'] +=1;
            }
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<26;j++){
                int a=j+'a';
                sb.append((char) a);
                sb.append(f[j]);
            }
            String key = sb.toString();
            if(map.get(key) == null){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }
        for(Map.Entry<String,List<String>> entry:map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }

}
