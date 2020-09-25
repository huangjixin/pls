package com.zwo.pls.modules.system.test;

/**
 * 猴子分桃解法：五只猴子分一堆桃子，第一只猴子把桃子分成5份，发现多出一个，然后拿走其中4份，把多出的一个给吃了；第二只猴子过来也把桃子分成5份，又发现多了一个，于是又拿走4份，吃了多出的，第三，第四，第五只猴子还是如此，刚刚好把桃子分完，
 * 请问最开始的桃子最少有多少个。
 */
public class MonkeyPitchImpl {

    public static int getPitches(int n){
        if(n==0){
            return 0;
        }else if(n==1) {
            return 6;
        }else {
            return 5*getPitches(n-1)+1;
        }
    }

    public static void main(String[] args) {
        int result = getPitches(5);
        System.out.println(result);
    }
}
