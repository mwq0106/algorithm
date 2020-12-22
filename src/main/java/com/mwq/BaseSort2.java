package com.mwq;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author mwq0106
 * @date 2020/8/18
 */
public class BaseSort2 {
    public static void main( String[] args) {
        System.out.println(stringAdd("999","1111"));
        Queue<Integer> queue=new LinkedList<>();
        int[] numbs1 = new int[]{3,1,5,2,6,9,100,200,250,1};
        heapsort(numbs1);
    }
    public static void heapsort(int[] numbs){
        buildheap(numbs);
        System.out.println(Arrays.toString(numbs));
        for(int i=0;i<numbs.length;i++){
            swap(numbs,0,numbs.length-i-1);
            heapSink(numbs,0,numbs.length-i-1);
        }
        System.out.println(Arrays.toString(numbs));
    }
    private static void buildheap(int[] numbs){
        for(int i=numbs.length/2-1;i>=0;i--){
            heapSink(numbs,i,numbs.length);
        }
    }
    private static void heapSink(int[] numbs,int start,int len){
//        System.out.println("start="+start);
        int leftChild=2*start+1;
        int rightChild=2*start+2;
        int index=start;
        if(leftChild<len&&numbs[leftChild]>numbs[index]){
            index=leftChild;
        }
        if(rightChild<len&&numbs[rightChild]>numbs[index]){
            index=rightChild;
        }
        if(index!=start){
            swap(numbs,index,start);
            heapSink(numbs,index,len);
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> queue=new LinkedList<>();
        int[] res=new int[nums.length+1-k];
        for(int i=0;i<k-1;i++){
            if(queue.isEmpty()){
                queue.add(i);
            }else{
                while(!queue.isEmpty()&&nums[queue.getLast()]<nums[i]){
                    queue.removeLast();
                }
                queue.add(i);
            }
        }
        for(int i=k-1;i<nums.length;i++){
            if(queue.isEmpty()){
                queue.add(i);
            }else{
                while (!queue.isEmpty()&&(i-queue.getFirst()+1>k)){
                    queue.removeFirst();
                }
                while(!queue.isEmpty()&&nums[queue.getLast()]<nums[i]){
                    queue.removeLast();
                }
                queue.add(i);
            }
            res[i-(k-1)]=nums[queue.getFirst()];
        }
        return res;
    }
    public static void mergesort(int[] numbs,int l,int r){
        if(l>=r){
            return;
        }
        int m = l + (r-l)/2;
        mergesort(numbs,l,m);
        mergesort(numbs,m+1,r);
        merge(numbs,l,r,m+1);
    }
    private static int[] aux;
    public static void merge(int[] numb,int l,int r,int m){
        int i = l,j = m;
        aux = new int[r-l+1];
        for (int k = 0; k <= r-l; k++) {
            aux[k] = numb[k+l];
        }
        for (int k = 0; k <= r-l; k++) {
            if(i>=m){
                aux[k] = numb[j];
                j++;
            }else if(j>r){
                aux[k] = numb[i];
                i++;
            }else if(numb[i] <= numb[j]){
                aux[k] = numb[i];
                i++;
            }else {
                aux[k] = numb[j];
                j++;
            }
        }
        for (int k = 0; k <= r-l ; k++) {
            numb[l+k] = aux[k];
        }
    }
    public static void quickSort(int[] numb,int l,int r){
        if(l>=r){
            return;
        }
        int index = partition2(numb,l,r);
        quickSort(numb,l,index-1);
        quickSort(numb,index+1,r);
    }
    public static void swap(int[] numbs,int a,int b){
        int temp = numbs[a];
        numbs[a] = numbs[b];
        numbs[b] = temp;
    }
    public static int partition(int[] numbs,int l,int r){
        int i = l,j=r;
        int index = numbs[l];
        i++;
        while (true){
            while (i<=r && numbs[i]<=index) {
                i++;
            }
            while (j>=l && numbs[j]>index) {
                j--;
            }
            if(i>=j){
                break;
            }
            swap(numbs,i,j);
        }
        swap(numbs,l,i-1);
        return i-1;
    }
    public static int partition2(int[] numbs,int l,int r){
        int index = l+1;
        int numb = numbs[l];
        for (int i = l+1; i <=r ; i++) {
            if(numbs[i]<numb){
                swap(numbs,i,index);
                index++;
            }
        }
        swap(numbs,index-1,l);
        return index-1;
    }
    public static int binarySearch(int[] numbs,int target){
        int low = 0,high = numbs.length-1;

        while (low<=high){
            int m = low + (high-low)/2;
            if(numbs[m]<target){
                low = m +1;
            }else if(numbs[m]>target){
                high = m -1;
            }else {
                return m;
            }
        }
        return low;
    }
    public static int leftBinarySearch(int[] numbs,int target){
        int low = 0,high = numbs.length-1;
        while (low <= high){
            int m = low + (high-low)/2;
            if(numbs[m]<target){
                low = m+1;
            }else if(numbs[m]>target){
                high = m-1;
            }else {
                if(m-1<0 || numbs[m-1] != target){
                    return m;
                }else {
                    high = m-1;
                }
            }
        }
        return low;
    }

    public static int rob(int[] numbs){
        int[] values = new int[numbs.length+1];
        values[0] = 0;
        values[1] = numbs[0];
        for (int i = 1; i < numbs.length; i++) {
            values[i+1] = Math.max(values[i],values[i-1]+numbs[i]);
        }
        return values[numbs.length];
    }

    /**
     * 字符串数字之和，大数之和
     * @param str1
     * @param str2
     * @return
     */
    public static String stringAdd(String str1,String str2){
        //翻转
        StringBuilder sbTemp = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            sbTemp.append(str1.charAt(str1.length() -1-i));
        }
        str1 = sbTemp.toString();
        sbTemp = new StringBuilder();
        for (int i = 0; i < str2.length(); i++) {
            sbTemp.append(str2.charAt(str2.length() -1-i));
        }
        str2 = sbTemp.toString();



        String temp = str1;
        if(str1.length()<str2.length()){
            str1 = str2;
            str2 = temp;
        }
        //str1是大的，str2是小的
        StringBuilder sb = new StringBuilder(str1);

        for (int i = 0; i < str2.length(); i++) {
            int next;
            int t1 = Integer.parseInt(((Character)sb.charAt(i)).toString());
            int t2 = Integer.parseInt(((Character)str2.charAt(i)).toString());
            int t = t1 +t2;
            Integer[] tArray = new Integer[2];
            if(t>9){
                next = 1;
                tArray[0] = 1;
                tArray[1] = t-10;
            }else {
                next = 0;
                tArray[0] = 0;
                tArray[1] = t;
            }
            sb.setCharAt(i,tArray[1].toString().charAt(0));
            if(next == 0){
                continue;
            }
            for (int j = i+1; j < sb.length(); j++) {
                Integer[] tempArray = new Integer[2];
                int nextTemp = Integer.parseInt(((Character)sb.charAt(j)).toString()) + next;
                if(nextTemp >9){
                    next =1;
                    tempArray[0]= 1;
                    tempArray[1] = nextTemp-10;
                }else {
                    next =0;
                    tempArray[0]= 0;
                    tempArray[1] = nextTemp;
                }
                sb.setCharAt(j,tempArray[1].toString().charAt(0));
                if(next == 0){
                    break;
                }
            }
            if(next == 1){
                sb.append("1");
            }
        }
        //翻转
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            res.append(sb.charAt(sb.length() -1-i));
        }
        return res.toString();
    }
}
