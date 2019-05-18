package com.zwo.pls.core.utils;

import com.zwo.pls.core.vo.Node;

import java.util.ArrayList;
import java.util.List;

public class TreeHelper {

    /**
     * 获取递归成树结构的列表
     * @param datas
     * @return
     */
    public static List<Node> getTreeNodes(List<Node> datas) {
        List<Node> result = new ArrayList<>();
        // 设置Node间父子关系
        List<Node> nodes = convertData2Node(datas);
        // 拿到根节点
        List<Node> rootNodes = getRootNodes(nodes);

        return rootNodes;
    }

    public static List<Node> getSortedNodes(List<Node> datas) {
        List<Node> result = new ArrayList<>();
        // 设置Node间父子关系
        List<Node> nodes = convertData2Node(datas);
        // 拿到根节点
        List<Node> rootNodes = getRootNodes(nodes);
        // 排序以及设置Node间关系
        for (Node node : rootNodes) {
            addNode(result, node, 0);
        }
        return result;
    }

    private static List<Node> convertData2Node(List<Node> nodes) {
        for (int i = 0; i < nodes.size(); i++) {
            Node n = nodes.get(i);
            for (int j = i + 1; j < nodes.size(); j++) {
                Node m = nodes.get(j);
                System.out.println(n.getId()+","+n.getParentId()+"_________________"+m.getId()+","+m.getParentId());
                if (m.getParentId() == n.getId() || n.getId().equals(m.getParentId())) {
                    n.getChildren().add(m);
//                    m.setParent(n);
                } else if (m.getId() == n.getParentId() || m.getId().equals(n.getParentId()) ) {
                    m.getChildren().add(n);
//                    n.setParent(m);
                }
            }
        }
        return nodes;
    }

    private static List<Node> getRootNodes(List<Node> nodes) {
        List<Node> root = new ArrayList<>();
        for (Node node : nodes) {
//            if (node.isRoot())
//                root.add(node);
            if (node.getParentId()!=null && "0".equals(node.getParentId()))
                root.add(node);
        }
        return root;
    }

    private static void addNode(List<Node> nodes, Node node, int currentLevel) {
        node.setLevel(currentLevel);
        nodes.add(node);
        if (node.isLeaf())
            return;
        for (int i = 0; i < node.getChildren().size(); i++) {
            addNode(nodes, node.getChildren().get(i), currentLevel + 1);
        }
    }
}