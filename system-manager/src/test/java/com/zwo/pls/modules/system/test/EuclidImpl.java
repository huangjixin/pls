package com.zwo.pls.modules.system.test;

public class EuclidImpl {

    public static int maxDivisor(int m, int n){
        if(n == 0){
            return m;
        }else {
            int temp = m%n;
            return maxDivisor(n,temp);
        }
    }

    public static void main(String[] args) {
        int result = maxDivisor(10568,8);
        System.out.println(result);
    }
}
