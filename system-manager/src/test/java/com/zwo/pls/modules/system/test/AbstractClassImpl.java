package com.zwo.pls.modules.system.test;

/**
 * 一句话描述该类功能：
 * Created by Tony(黄记新) in 2019/8/26
 */
public class AbstractClassImpl {
    int test(){
        return AbstractClass.i;
    }

    public static void main(String[] args) {
        AbstractClassImpl a = new AbstractClassImpl();
        System.out.println(a.test());
    }
}
