package com.zwo.pls.core.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Node {

    private String id;//结点id
    private String parentId;//父结点id
    private String name;//结点值
    private List<Node> children = new ArrayList<>();//孩子结点列表
    private Node parent;
    private int level;

//    public Node(String id, String pid, String name) {
//        this.id = id;
//        this.parentId = pid;
//        this.name = name;
//    }

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

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

//    public Node getParent() {
//        return parent;
//    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isRoot() {
        return parent == null;
    }

    public boolean isLeaf() {
        return children.size() == 0;
    }
}