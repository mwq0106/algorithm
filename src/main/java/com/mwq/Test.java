package com.mwq;

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
        String s = "bbbb";

        int start=0,end =0;
        int max = 0;
        int[] num = new int[126];
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
        System.out.print(max);
    }
}
