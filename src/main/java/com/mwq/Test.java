package com.mwq;



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
        Queue q = new PriorityQueue();
        Queue<Integer> q1 = new PriorityQueue<>((o1,o2)-> {return o2-o1;});
        Queue<Integer> q2 =new PriorityQueue<>((x, y) -> y - x);
        String[] a = new String[3];
        Arrays.sort(a,(String x,String y)-> y.compareTo(x));
    }
}
