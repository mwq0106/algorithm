package com.mwq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @author mwq0106
 * @date 2020/6/26
 */
public class LeetCode {
    public static void main(String[] args) {

        LeetCode leetCode = new LeetCode();
        ListNode node1 = new ListNode(8);
        node1.next = new ListNode(6);
        ListNode node2 = new ListNode(3);
        node2.next = new ListNode(3);
        ListNode res = leetCode.addTwoNumbers(node1,node2);
        while (res !=null){
            System.out.print(res.val+" ");
            res= res.next;
        }
    }

    /**
     * 406. 根据身高重建队列
     * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，
     * 其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
     *
     * 输入:
     * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
     *
     * 输出:
     * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
     *
     * 先根据K从小到大排序，K相同则H从小到大排序
     * [[5,0],[7,0],[6,1],[7,1],[5,2],[4,4]]
     * 从前往后遍历，先把K为0的放进结果队列，每遍历一个区间i，就从头开始遍历，区间j,
     * 如果当前区间j的h大于i的h，则计数器加一，计数器和区间i的K值相等，则说明可以寻找插入位置了，
     * 需要注意的是还不能直接插入，而是需要继续往后找，找到第一个比区间i的h大的区间，
     * 这个区间才是可以插入的位置，因为直接插入会影响前面已经插入的数据。
     *
     *
     * 编写的时候需要注意，从头遍历的时候，要使用已经确定顺序的队列去遍历，而不是使用老的数组
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        if(people.length == 0){
            return people;
        }
        //这种排序方法要记住
        Arrays.sort(people,(a,b) -> a[1] == b[1]?a[0]-b[0]:a[1]-b[1]
        );
//        System.out.println(JSON.toJSONString(people));
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            if(people[i][1] == 0){
                list.add(people[i]);
                continue;
            }
            int count = 0;
            for (int j = 0; j < i; j++) {
                if(list.get(j)[0]>=people[i][0]){
                    count++;
                }
                if(count==people[i][1]){
                    //开始寻找第一个大于当前数的值
                    int k;
                    for (k = j+1; k < i; k++) {
                        if(list.get(k)[0]>people[i][0]){
                            break;
                        }
                    }
                    list.add(k,people[i]);
                    break;
                }
            }
        }
        return list.toArray(new int[people.length][]);
    }
    public boolean isSubsequence(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chars2 = t.toCharArray();
        int last = 0;
        for (int i = 0; i < chars.length; i++) {
            boolean have = false;
            for (int j = last; j < chars2.length; j++) {
                if(chars[i] == chars2[j]){
                    have = true;
                    last = j+1;
                    break;
                }
            }
            if(!have){
                return false;
            }
        }
        return true;
    }
    public int maxSubArray(int[] nums) {
        int pre_max = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(pre_max<0){
                if(nums[i]>pre_max){
                    pre_max = nums[i];
                    if(pre_max > max){
                        max = pre_max;
                    }
                }else {
                    pre_max = nums[i];
                }
            }else {
                pre_max = pre_max + nums[i];
                if(pre_max > max){
                    max = pre_max;
                }
            }
        }
        return max;
    }
    public List<Integer> partitionLabels(String S) {
        int i = 0;
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        List<Integer> list = new LinkedList<>();
        char[] chars = S.toCharArray();
        int index;
        while (true){
            set1.clear();
            set2.clear();
            set1.add(chars[i]);
            index = i;
            list.add(index);
            for (int j = i+1; j < chars.length; j++) {
                set2.add(chars[j]);
                if(set1.contains(chars[j])){
                    index = j;
                    set1.addAll(set2);
                }
            }
            i = index + 1;
            if(i == chars.length){
                break;
            }
        }
        List<Integer> result = new LinkedList<>();
        if(list.size() == 1){
            result.add(chars.length);
            return result;
        }
//        result.add(list.get(1)-list.get(0));
        for (int j = 1; j < list.size(); j++) {
            result.add(list.get(j)-list.get(j-1));
        }
        result.add(chars.length - list.get(list.size()-1));
        return result;
    }
    public int hammingDistance(int x, int y) {
        int a = x ^ y;
        return get1Nums(a);
    }
    private int get1Nums(int a){
        int n = 0;
        while (a != 0){
            a = a&(a-1);
            n++;
        }
        return n;
    }
    public int singleNumber(int[] nums) {
        int a = nums[0];
        for (int i = 1; i < nums.length; i++) {
            a ^= nums[i];
        }
        return a;
    }
    public int missingNumber(int[] nums) {
        if(nums.length == 1){
            if(nums[0] == 0){
                return 1;
            }
            if(nums[0] == 1){
                return 0;
            }
        }
        int maxNumb = nums.length;
        int maxIndex = -1;
        int i = 0;
        while (i<nums.length){
            if(nums[i] == maxNumb){
                maxIndex = i;
                i++;
                continue;
            }
            if(nums[i] == i){
                i++;
            }else {
                swap(nums,i,nums[i]);
            }
        }
        if(maxIndex == -1){
            return nums.length;
        }
        return maxIndex;
    }
    private void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public int missingNumber2(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; ++i){
            res ^= nums[i];
            res ^= i;
        }
        return res;
    }
    public int reverseBits(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            ret |= (n & 1);
            if(i!=31){
                ret <<= 1;
            }
            n >>>= 1;
        }
        return ret;
    }
    public boolean isPowerOfTwo(int n) {
        if(n <= 0){
            return false;
        }
        int i = 0;
        while (n != 0){
            n = n & (n-1);
            i++;
        }
        if(i == 1){
            return true;
        }
        return false;
    }
    public boolean isPowerOfFour(int num) {
        int n = num &(num-1);
        if(n != 0) {
            return false;
        }
        String binaryString = Integer.toBinaryString(num);
        for (int i = 0; i < binaryString.length(); i++) {
            if(binaryString.charAt(binaryString.length()-1-i) == '1'){
                if((i & 1)==0){
                    return true;
                }
            }
        }
        return false;
    }
    public int getSum(int a, int b) {
        if(a <0 && b<0){
            a = -a;
            for (int i = 0; i < Math.abs(b); i++) {
                a = increase(a);
            }
            return -a;
        }else if(a>0 && b>0){
            for (int i = 0; i < b; i++) {
                a = increase(a);
            }
            return a;
        }else {
            if(a<0){
                for (int i = 0; i < b; i++) {
                    a = increase(a);
                }
                return a;
            }else {
                for (int i = 0; i < a; i++) {
                    b = increase(b);
                }
                return b;
            }
        }
    }
    private int increase(int c){
        if((c & 1)==1){
            c &= 0xfffffffe;
            int mask = 2;
            for (int i = 0; i < 32; i++) {
                if((c & mask) != 0){
                    c ^=mask;
                    mask <<=1;
                }else {
                    c |= mask;
                    break;
                }
            }
        }else {
            c |=1;
        }
        return c;
    }
    public List<String> letterCombinations(String digits) {
        List<String> res = letterCombinationsDfs(digits,0);
        return res;
    }
    private String letterMap[] = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    private List<String> letterCombinationsDfs(String digits,int start){
        if(start >= digits.length()){
            return new LinkedList<>();
        }
        char s = digits.charAt(start);
        List<String> list = letterCombinationsDfs(digits,start+1);
        String s2 = letterMap[s-'0'];
        List<String> res = new LinkedList<>();
        for (int i = 0; i < s2.length(); i++) {
            if(list.size() == 0){
                res.add(((Character) s2.charAt(i)).toString());
            }
            for (int j = 0; j < list.size(); j++) {
                res.add(s2.charAt(i) + list.get(j));
            }

        }
        return res;
    }
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode res = new ListNode();
        int next = 0;
        ListNode temp = res;
        while (true){
            ListNode tnode = new ListNode(next);
            next=0;
            if(node1 != null){
                tnode.val += node1.val;
                node1=node1.next;
            }
            if(node2 != null){
                tnode.val += node2.val;
                node2=node2.next;
            }
            if(tnode.val >9){
                tnode.val-=10;
                next = 1;
            }
            if(node1 ==null && node2==null && next==1){
                tnode.next = new ListNode(1);
            }
            temp.next = tnode;
            temp=temp.next;
            if(node1 ==null && node2==null){
                break;
            }
        }
        return res.next;
    }
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }

        int start=0,end =0;
        int max = 0;
        int[] num = new int[26];
        for (int i = 0; i < 26; i++) {
            num[i] =-1;
        }
        num[s.charAt(0) - 'a'] = 0;
        while (true){
            end ++;
            if(end>=s.length()){
                if(end -start >max){
                    max = end-start;
                }
                break;
            }
            char c = s.charAt(end);
            int index = num[c - 'a'];
            if(index != -1){
                while (start <= index){
                    num[s.charAt(start) -'a'] = -1;
                    start ++;
                }
            }
            num[c - 'a'] = end;
            if(end -start+1 >max){
                max = end-start+1;
            }
        }
//        System.out.print(max);
        return max;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length+nums2.length;
        Queue<Integer> q2 = new PriorityQueue<>();
        Queue<Integer> q1 = new PriorityQueue<>((x, y) -> y - x);
        int a =0;
        int b=0;
        for(int i=0;i<n;i++){
            int min;
            if(a>=nums1.length){
                min = nums2[b];
                b++;
            }else if(b>= nums2.length){
                min = nums1[a];
                a++;
            }else if(nums1[a]<nums2[b]){
                min = nums1[a];
                a++;
            }else {
                min = nums2[b];
                b++;
            }
            if(i%2==0){
                q1.add(min);
            }else{
                q2.add(min);
            }
            if(q1.size() >0 && q2.size()>0 && q1.peek() > q2.peek()){
                int temp1 = q1.poll();
                int temp2 = q2.poll();
                q1.add(temp2);
                q2.add(temp1);
            }
        }
        if(n %2==0){
            int temp1 = q1.poll();
            int temp2 = q2.poll();
            return (temp1 + temp2)/2.0;
        }else{
            if(q1.size() > q2.size()){
                return q1.poll();
            }
            return q2.poll();
        }
    }
}
