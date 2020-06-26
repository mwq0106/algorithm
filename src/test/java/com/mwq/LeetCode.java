package com.mwq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author mwq0106
 * @date 2020/6/26
 */
public class LeetCode {
    public static void main(String[] args) {
        int[][] people = new int[6][];
        people[0] = new int[]{7,0};
        people[1] = new int[]{4,4};
        people[2] = new int[]{7,1};
        people[3] = new int[]{5,0};
        people[4] = new int[]{6,1};
        people[5] = new int[]{5,2};
//        people[0] = new int[]{1,0};
//        people[1] = new int[]{1,4};
//        people[2] = new int[]{1,1};
//        people[3] = new int[]{2,0};
//        people[4] = new int[]{1,3};
//        people[5] = new int[]{1,2};
        LeetCode leetCode = new LeetCode();
        int[][] result = leetCode.reconstructQueue(people);
        System.out.println(JSON.toJSONString(result));
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
}
