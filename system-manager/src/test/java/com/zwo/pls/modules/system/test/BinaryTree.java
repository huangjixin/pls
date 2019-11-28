package com.zwo.pls.modules.system.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树
 */
public class BinaryTree {
    int data;
    BinaryTree leftTree;
    BinaryTree rightTree;

//    public BinaryTree() {
//
//    }

    public void BinaryTree(int data, BinaryTree leftTree, BinaryTree rightTree) {
        this.data = data;
        this.leftTree = leftTree;
        this.rightTree = rightTree;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTree getLeftTree() {
        return leftTree;
    }

    public void setLeftTree(BinaryTree leftTree) {
        this.leftTree = leftTree;
    }

    public BinaryTree getRightTree() {
        return rightTree;
    }

    public void setRightTree(BinaryTree rightTree) {
        this.rightTree = rightTree;
    }

    /**
     * 前序遍历实现。
     * @param binaryTree
     */
    public static void preOrderTraveral(BinaryTree binaryTree, List list){
        // 出口，停止条件；
        if(binaryTree == null){
            return;
        }
//        System.out.println(binaryTree.data);
        list.add(binaryTree.data);
        preOrderTraveral(binaryTree.getLeftTree(),list);
        preOrderTraveral(binaryTree.getRightTree(),list);
    }

    /**
     * 中序遍历实现。
     * @param binaryTree
     */
    public static void inOrderTraveral(BinaryTree binaryTree, List list){
        // 出口，停止条件；
        if(binaryTree == null){
            return;
        }
        inOrderTraveral(binaryTree.getLeftTree(),list);
//        System.out.println(binaryTree.data);
        list.add(binaryTree.data);
        inOrderTraveral(binaryTree.getRightTree(),list);
    }

    /**
     * 后序遍历实现。
     * @param binaryTree
     */
    public static void postOrderTraveral(BinaryTree binaryTree, List list){
        // 出口，停止条件；
        if(binaryTree == null){
            return;
        }
        postOrderTraveral(binaryTree.getLeftTree(),list);
        postOrderTraveral(binaryTree.getRightTree(),list);
//        System.out.println(binaryTree.data);
        list.add(binaryTree.data);

    }

    public static void main(String[] args) {
        BinaryTree binaryTree1 = new BinaryTree();
        BinaryTree binaryTree2 = new BinaryTree();
        BinaryTree binaryTree3 = new BinaryTree();
        BinaryTree binaryTree4 = new BinaryTree();
        BinaryTree binaryTree5 = new BinaryTree();
        binaryTree1.setData(1);
        binaryTree2.setData(2);
        binaryTree3.setData(3);
        binaryTree4.setData(4);
        binaryTree5.setData(5);
        binaryTree1.setLeftTree(binaryTree2);
        binaryTree1.setRightTree(binaryTree3);
        binaryTree2.setLeftTree(binaryTree4);
        binaryTree4.setRightTree(binaryTree5);

        List list = new ArrayList();
        preOrderTraveral(binaryTree1,list);

        for (int i = 0; i < list.size(); i++) {
            if(i==(list.size()-1)){
                System.out.print(list.get(i));
            }else{
                System.out.print(list.get(i)+",");
            }

        }

        System.out.println();

        list = new ArrayList();
        inOrderTraveral(binaryTree1,list);

        for (int i = 0; i < list.size(); i++) {
            if(i==(list.size()-1)){
                System.out.print(list.get(i));
            }else{
                System.out.print(list.get(i)+",");
            }

        }

        System.out.println();

        list = new ArrayList();
        postOrderTraveral(binaryTree1,list);

        for (int i = 0; i < list.size(); i++) {
            if(i==(list.size()-1)){
                System.out.print(list.get(i));
            }else{
                System.out.print(list.get(i)+",");
            }

        }
    }
}
