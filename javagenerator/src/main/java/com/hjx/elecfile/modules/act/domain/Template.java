package com.hjx.elecfile.modules.act.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "act_template")
public class Template implements Serializable {
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 类型
     */
    @Column(name = "TYPE")
    private Integer type;

    /**
     * 排序
     */
    @Column(name = "SORT")
    private Long sort;

    /**
     * 状态
     */
    @Column(name = "STATUS")
    private Integer status;

    /**
     * 描述
     */
    @Column(name = "DESCRIPTION")
    private String description;

    /**
     * 名称
     */
    @Column(name = "NAME")
    private String name;

    /**
     * 创建人
     */
    @Column(name = "CREATE_BY")
    private String createBy;

    /**
     * 更新人
     */
    @Column(name = "UPDATE_BY")
    private String updateBy;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    /**
     * 活动描述横坐标
     */
    @Column(name = "ACT_H_ORDINATE")
    private Integer actHOrdinate;

    /**
     * 活动描述纵坐标
     */
    @Column(name = "ACT_V_ORDINATE")
    private Integer actVOrdinate;

    /**
     * 开始活动模板ID
     */
    @Column(name = "START_ELEMENT_ID")
    private String startElementId;

    /**
     * 参与活动ID
     */
    @Column(name = "PARTICIAPE_ELEMENT_ID")
    private String particiapeElementId;

    @Column(name = "ICON")
    private String icon;

    @Column(name = "URL")
    private String url;

    @Column(name = "PARENT_ID")
    private String parentId;

    private static final long serialVersionUID = 1L;

    /**
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取类型
     *
     * @return TYPE - 类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型
     *
     * @param type 类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取排序
     *
     * @return SORT - 排序
     */
    public Long getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Long sort) {
        this.sort = sort;
    }

    /**
     * 获取状态
     *
     * @return STATUS - 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取描述
     *
     * @return DESCRIPTION - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取名称
     *
     * @return NAME - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取创建人
     *
     * @return CREATE_BY - 创建人
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人
     *
     * @param createBy 创建人
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 获取更新人
     *
     * @return UPDATE_BY - 更新人
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新人
     *
     * @param updateBy 更新人
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * 获取创建时间
     *
     * @return CREATE_TIME - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return UPDATE_TIME - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取活动描述横坐标
     *
     * @return ACT_H_ORDINATE - 活动描述横坐标
     */
    public Integer getActHOrdinate() {
        return actHOrdinate;
    }

    /**
     * 设置活动描述横坐标
     *
     * @param actHOrdinate 活动描述横坐标
     */
    public void setActHOrdinate(Integer actHOrdinate) {
        this.actHOrdinate = actHOrdinate;
    }

    /**
     * 获取活动描述纵坐标
     *
     * @return ACT_V_ORDINATE - 活动描述纵坐标
     */
    public Integer getActVOrdinate() {
        return actVOrdinate;
    }

    /**
     * 设置活动描述纵坐标
     *
     * @param actVOrdinate 活动描述纵坐标
     */
    public void setActVOrdinate(Integer actVOrdinate) {
        this.actVOrdinate = actVOrdinate;
    }

    /**
     * 获取开始活动模板ID
     *
     * @return START_ELEMENT_ID - 开始活动模板ID
     */
    public String getStartElementId() {
        return startElementId;
    }

    /**
     * 设置开始活动模板ID
     *
     * @param startElementId 开始活动模板ID
     */
    public void setStartElementId(String startElementId) {
        this.startElementId = startElementId == null ? null : startElementId.trim();
    }

    /**
     * 获取参与活动ID
     *
     * @return PARTICIAPE_ELEMENT_ID - 参与活动ID
     */
    public String getParticiapeElementId() {
        return particiapeElementId;
    }

    /**
     * 设置参与活动ID
     *
     * @param particiapeElementId 参与活动ID
     */
    public void setParticiapeElementId(String particiapeElementId) {
        this.particiapeElementId = particiapeElementId == null ? null : particiapeElementId.trim();
    }

    /**
     * @return ICON
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * @return URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * @return PARENT_ID
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Template other = (Template) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getActHOrdinate() == null ? other.getActHOrdinate() == null : this.getActHOrdinate().equals(other.getActHOrdinate()))
            && (this.getActVOrdinate() == null ? other.getActVOrdinate() == null : this.getActVOrdinate().equals(other.getActVOrdinate()))
            && (this.getStartElementId() == null ? other.getStartElementId() == null : this.getStartElementId().equals(other.getStartElementId()))
            && (this.getParticiapeElementId() == null ? other.getParticiapeElementId() == null : this.getParticiapeElementId().equals(other.getParticiapeElementId()))
            && (this.getIcon() == null ? other.getIcon() == null : this.getIcon().equals(other.getIcon()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getActHOrdinate() == null) ? 0 : getActHOrdinate().hashCode());
        result = prime * result + ((getActVOrdinate() == null) ? 0 : getActVOrdinate().hashCode());
        result = prime * result + ((getStartElementId() == null) ? 0 : getStartElementId().hashCode());
        result = prime * result + ((getParticiapeElementId() == null) ? 0 : getParticiapeElementId().hashCode());
        result = prime * result + ((getIcon() == null) ? 0 : getIcon().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", sort=").append(sort);
        sb.append(", status=").append(status);
        sb.append(", description=").append(description);
        sb.append(", name=").append(name);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", actHOrdinate=").append(actHOrdinate);
        sb.append(", actVOrdinate=").append(actVOrdinate);
        sb.append(", startElementId=").append(startElementId);
        sb.append(", particiapeElementId=").append(particiapeElementId);
        sb.append(", icon=").append(icon);
        sb.append(", url=").append(url);
        sb.append(", parentId=").append(parentId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}