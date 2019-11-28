package com.zwo.pls.modules.system.test;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeTest {
    private String id;
    private String parentId;
    private String name;
    private List children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getChildren() {
        return children;
    }

    public void setChildren(List children) {
        this.children = children;
    }

    /**
     * 重载构造函数。
     * @param id
     * @param parentId
     * @param name
     */
    public TreeNodeTest(String id, String parentId, String name) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
    }

    public static List getTree(List list){
        List result = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            TreeNodeTest treeNodeTest = (TreeNodeTest) list.get(i);
            // 根部开始
            if("0".equals(treeNodeTest.getParentId())){
                treeNodeTest = findChildren(treeNodeTest,list);
                result.add(treeNodeTest);
            }

        }
        return result;
    }

    private static TreeNodeTest findChildren(TreeNodeTest treeNodeTest,List list){
        int size = list.size();
        for (int i = 0; i < size; i++) {
            TreeNodeTest currentNode = (TreeNodeTest) list.get(i);
            if(treeNodeTest.getId().equals(currentNode.getParentId())){
                if(treeNodeTest.getChildren() == null){
                    treeNodeTest.setChildren(new ArrayList());
                }

                currentNode = findChildren(currentNode,list);
                treeNodeTest.getChildren().add(currentNode);


            }
        }
        return treeNodeTest;
    }

    public static void main(String[] args) {
        List list = new ArrayList();
        TreeNodeTest treeNodeTest0 = new TreeNodeTest("1","0","系统管理");
        TreeNodeTest treeNodeTest1 = new TreeNodeTest("2","1","用户管理");
        TreeNodeTest treeNodeTest2 = new TreeNodeTest("3","2","用户查询");
        TreeNodeTest treeNodeTest3 = new TreeNodeTest("4","2","用户删除");
        TreeNodeTest treeNodeTest4 = new TreeNodeTest("4","2","用户添加");
        TreeNodeTest treeNodeTest5 = new TreeNodeTest("4","2","用户修改");

        list.add(treeNodeTest0);
        list.add(treeNodeTest1);
        list.add(treeNodeTest2);
        list.add(treeNodeTest3);
        list.add(treeNodeTest4);
        list.add(treeNodeTest5);

        List result = getTree(list);

        System.out.println(result.toString());

    }
}
