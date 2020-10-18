package com.mwq;

import java.util.LinkedList;
import java.util.List;

/**
 * 基本排序算法
 *
 */
public class BaseSort {
    public static void main( String[] args) {
        int[] numbs1 = new int[]{3,1,5,2,6,9,100,200,250,1,1};
        int[] numbs2 = new int[]{2,1};

        List<int[]> list= new LinkedList<>();
        list.add(numbs1);
        list.add(numbs2);
        for (int i = 0; i < list.size(); i++) {
            quickSort(list.get(i));
        }

    }

    /**
     * 选择排序，每次都选择最小的放在左边
     * @param nums
     */
    public static void selectionSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int minIndex = i;
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j] < min){
                    min = nums[j];
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = min;
            nums[minIndex] = temp;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+",");
        }
        System.out.println();
    }

    /**
     * 冒泡排序，从左向右，最大的一直向右移动
     * @param numbs
     */
    public static void bubbleSort(int[] numbs){
        for (int i = 0; i < numbs.length; i++) {
            for (int j = 0; j < numbs.length-i-1; j++) {
               if(numbs[j]>numbs[j+1]){
                   int temp = numbs[j];
                   numbs[j] = numbs[j+1];
                   numbs[j+1] = temp;
               }
            }
        }
        for (int i = 0; i < numbs.length; i++) {
            System.out.print(numbs[i]+",");
        }
        System.out.println();
    }

    /**
     * 插入排序，左边是有序数组，从右边一个个选择插入左边的合适位置
     * @param numbs
     */
    public static void insertionSort(int[] numbs){
        for (int i = 0; i < numbs.length; i++) {
            for (int j = i; j > 0; j--) {
                if(numbs[j] < numbs[j-1]){
                    int temp = numbs[j];
                    numbs[j] = numbs[j-1];
                    numbs[j-1] = temp;
                }
            }
        }
        for (int i = 0; i < numbs.length; i++) {
            System.out.print(numbs[i]+",");
        }
        System.out.println();
    }
    public static void swap(int[] numbs,int a,int b){
        int temp =  numbs[a];
        numbs[a] = numbs[b];
        numbs[b] = temp;
    }

    /**
     * 希尔排序，对选择排序的优化，增加增量序列概念，每次对增量系列内的数组进行排序，
     * 逐渐缩小增量序列，直到为1
     * @param numbs
     */
    public static void shellSort(int[] numbs){
        //先循环增量系列，直到为1
        for (int gap = numbs.length/2; gap > 0; gap/=2) {
            //向右循环所有分组
            for (int i = gap; i < numbs.length; i++) {
                //向左循环分组内所有的元素
                for (int j = i; j-gap >=0 ; j-=gap) {
                    if(numbs[j] < numbs[j-gap]){
                        swap(numbs,j,j-gap);
                    }
                }
            }
        }
        for (int i = 0; i < numbs.length; i++) {
            System.out.print(numbs[i]+",");
        }
        System.out.println();
    }

    /**
     * 归并排序
     * @param numbs
     */
    public static void mergeSort(int[] numbs){
        mergeSortDigui(numbs,0,numbs.length-1);
        for (int i = 0; i < numbs.length; i++) {
            System.out.print(numbs[i]+",");
        }
        System.out.println();
    }

    /**
     * 递归调用，拆分大数组为两个小数组，进行排序，然后合并
     * @param numbs
     * @param l
     * @param r
     */
    private static void mergeSortDigui(int[] numbs,int l,int r){
        if(l>=r){
            return;
        }
        int m = (l+r)/2;
        mergeSortDigui(numbs,l,m);
        mergeSortDigui(numbs,m+1,r);
        merge(numbs,l,r,m+1);
    }

    /**
     * 将两个有序数组合并
     * @param numbs
     * @param l
     * @param r
     * @param m
     */
    private static void merge(int[] numbs,int l,int r,int m){
        int[] aux = new int[r-l+1];
        int i = l,j = m;
        for (int k = l; k <= r; k++) {
            aux[k-l] = numbs[k];
        }
        for (int k = l; k <= r; k++) {
            if(i >= m){
                numbs[k] = aux[j-l];
                j++;
            }else if(j > r){
                numbs[k] = aux[i-l];
                i++;
            }else if(aux[i-l] > aux[j-l]){
                numbs[k] = aux[j-l];
                j++;
            }else {
                numbs[k] = aux[i-l];
                i++;
            }
        }
    }

    /**
     * 快速排序
     * @param numbs
     */
    public static void quickSort(int[] numbs){
        quickSortDigui(numbs,0,numbs.length-1);
        for (int i = 0; i < numbs.length; i++) {
            System.out.print(numbs[i]+",");
        }
        System.out.println();
    }
    private static void quickSortDigui(int[] numbs,int l,int r){
        if(l>=r){
            return;
        }
        int m = getIndex(numbs,l,r);
        quickSortDigui(numbs,l,m-1);
        quickSortDigui(numbs,m+1,r);
    }
    private static int getIndex(int[] numbs,int l,int r){
        //选取切分点为第一个元素
        int index = l;
        int i = l;
        int j = r;
        while (i<j){
            if(numbs[i]<=numbs[index]){
                i++;
            }
            if(numbs[j]>=numbs[index]){
                j--;
            }
            if(i == j){
                break;
            }
            if(numbs[i]>numbs[index] && numbs[j]<numbs[index]){
                swap(numbs,i,j);
                i++;
                j--;
            }
        }

//        swap(numbs,index,j);
        return i;
    }

    /**
     * 保存小于index值的左指针，从左向右查找小于index的数，找到，
     * 与左指针交换，左指针++，继续向右找
     * @param numbs
     * @param l
     * @param r
     * @return
     */
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
    /**
     * 堆排序
     * @param numbs
     */
    public static void heapsort(int[] numbs){
        buildheap(numbs);
        for (int i = 0; i < numbs.length; i++) {
            swap(numbs,0,numbs.length - 1 - i);
            heapify(numbs,0,numbs.length-i-1);
        }
    }
    public static void buildheap(int[] numbs){
        for (int i = numbs.length/2 -1; i >=0 ; i--) {
            heapify(numbs,i,numbs.length);
        }
    }
    public static void heapify(int[] numbs,int index,int len){
        int maxIndex = index;

        if(2*index + 1<len && numbs[2*index+1]>numbs[maxIndex]){
            maxIndex = 2*index+1;
        }
        if(2*index + 2<len && numbs[2*index+2]>numbs[maxIndex]){
            maxIndex = 2*index+2;
        }
        if(maxIndex != index){
            swap(numbs,maxIndex,index);
            heapify(numbs,maxIndex,len);
        }
    }
}
