package com.zwo.pls.modules.system.test;

/**
 * @author 黄记新
 * @date 2019-11-28
 * 斐波那契数列递归实现：1 1 2 3 5 8 13 21 34 55 ……
 * 即当前项都是前两项之和。
 */
public class FabonacciImpl {
    public static int fabonacci(int n){
        if(n == 1){
            return 1;
        }else if (n==2){
            return 1;
        }else {
            return fabonacci(n-1)+fabonacci(n-2);
        }
    }

    public static void main(String[] args) {
        int result = fabonacci(40);
        System.out.println(result);
    }
}
