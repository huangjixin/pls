package com.zwo.pls.modules.system.test;

/**
 * 一句话描述该类功能：
 * Created by Tony(黄记新) in 2019/8/26
 */
public class B extends A {
    // 子类重写父类方法，访问权限不能降低,所以用private和不写是错误的，protected和public。
    protected int method1(int a, int b){
        return  0;
    }

    // 参数不一样，这个方法属于重载。
    private int method1(int a){
        return  0;
    }
    // 参数不一样，这个方法属于重载。
    private int method1(int a,long b){
        return  0;
    }

    void test(){
        System.out.println("B test");
    }

    void B(){

    }

    // 构造方法可以重载。
    void  B(int a){

    }
    // 静态方法无法在子类复写。
//    void test1(){
//        System.out.println("B test");
//    }

    // 考察字符串与基本类型拼装问题。第一个字符串后续都按照字符串处理。
    void  testAdd(){
        System.out.println(6+6+"(Result)");
    }

    // 考察字符串引用的问题。
    void  testStr(){
        String a = " test ";
        String b = a;
        b.toUpperCase();
        b.trim();
        System.out.println("a:"+a+",b:"+b);
    }

    public static void main(String[] args) {
        B b = new B();
        b.test();
        A a = (A)b;
        a.test();
        // 父类指向子类的实例。
        // B test
        // B test

        // 考察字符串与基本类型拼装问题。第一个字符串后续都按照字符串处理。
        b.testAdd();

        b.testStr();// 预计结果：test test
    }
}
