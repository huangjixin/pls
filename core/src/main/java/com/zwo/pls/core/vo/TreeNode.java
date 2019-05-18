package com.zwo.pls.core.vo;

import java.io.Serializable;

/**
 * 一句话描述该类功能：树节点基础节点。
 * Created by Tony(黄记新) in 2019/5/18
 */
public class TreeNode implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String parentId;

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
}
