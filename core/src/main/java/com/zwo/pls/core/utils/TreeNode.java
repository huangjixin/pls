package com.zwo.pls.core.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 黄记新
 * @date 2019-11-27
 */
public class TreeNode implements Serializable {

    private String id;
    private String parentId;

    private List<TreeNode> children;

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

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    private static List<TreeNode> listGetStree(List<TreeNode> list) {
        List<TreeNode> treeList = new ArrayList<TreeNode>();
        for (TreeNode tree : list) {
            //找到根
            if ("0".equals(tree.getParentId()) || tree.getParentId()== null) {
                treeList.add(tree);
            }
            //找到子
            for (TreeNode treeNode : list) {
                if (tree.getId().equals(treeNode.getParentId())) {
                    if (tree.getChildren() == null) {
                        tree.setChildren(new ArrayList<TreeNode>());
                    }
                    tree.getChildren().add(treeNode);
                }
            }
        }
        return treeList;
    }

    /**
     * 方法二、
     * @param list
     * @return
     */
    public static List listToTree(List list) {
        //用递归找子。
        List treeList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            TreeNode tree = (TreeNode) list.get(i);
            if ("0".equals(tree.getParentId()) || tree.getParentId()== null) {
                treeList.add(findChildren(tree, list));
            }
        }
        return treeList;
    }

    private static TreeNode findChildren(TreeNode tree, List<TreeNode> list) {
        for (TreeNode node : list) {
            if (tree.getId().equals(node.getParentId())) {
                if (tree.getChildren() == null) {
                    tree.setChildren(new ArrayList<TreeNode>());
                }
                tree.getChildren().add(findChildren(node, list));
            }
        }
        return tree;
    }

    /**
     *方法三
     * @param list
     * @return
     */
    private static List<TreeNode> toTree(List<TreeNode> list) {
        List<TreeNode> treeList = new ArrayList<TreeNode>();
        for (TreeNode tree : list) {
            if("0".equals(tree.getParentId()) || tree.getParentId()== null){
                treeList.add(tree);
            }
        }
        for (TreeNode tree : list) {
            toTreeChildren(treeList,tree);
        }
        return treeList;
    }

    private static void toTreeChildren(List<TreeNode> treeList, TreeNode tree) {
        for (TreeNode node : treeList) {
            if(tree.getId().equals(node.getParentId())){
                if(node.getChildren() == null){
                    node.setChildren(new ArrayList<TreeNode>());
                }
                node.getChildren().add(tree);
            }
            if(node.getChildren() != null){
                toTreeChildren(node.getChildren(),tree);
            }
        }
    }

}
