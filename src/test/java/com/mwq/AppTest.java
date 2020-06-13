package com.mwq;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple BaseSort.
 */
public class AppTest 
{
    /**
     *
     */
    @Test
    public void repeatNumbInArray()
    {
        System.out.println(digui(4));
    }
    public int digui(int n){
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }else if(n == 2){
            return 2;
        }
        return digui(n-1)+digui(n-2);
    }
    @Test
    public void tesst(){
        System.out.println(get(11));
    }
    public int get(int k){
        int numb = k;
        int i = 0;
        int count = 0;
        while (numb >0){
            if(numb/2>0){
                i++;
                numb /= 2;
            }else {
                count++;
                numb = k-(int) Math.pow(2,i);
                k = k - (int) Math.pow(2,i);
                i = 0;
            }
        }
        return count;
    }
}
