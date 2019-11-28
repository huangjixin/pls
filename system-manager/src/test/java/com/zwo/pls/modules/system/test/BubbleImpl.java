package com.zwo.pls.modules.system.test;

import java.util.Arrays;
import java.util.List;

/**
 * 冒泡算法实现。
 */
public class BubbleImpl {

    /**
     * 冒泡算法。
     * @param list
     * @return
     */
    public static Integer[] bubble(Integer[] list){
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < i; j++) {
                if(list[i]<list[j]){
                    Integer temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
        return list;
    }



    public static void main(String[] args) {
        Integer[] ob = {11,2,22,33,45,2,5,99,9,1000,88,74};
        System.out.println("排序前："+Arrays.toString(ob));
        Integer[] list = bubble(ob);
        System.out.println("排序后："+Arrays.toString(list));

    }
}
