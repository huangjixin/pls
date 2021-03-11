package com.hjx.elecfile.modules.act.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "act_activity")
public class Activity implements Serializable {
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
     * 活动模板ID
     */
    @Column(name = "TEMPLATE_ID")
    private String templateId;

    /**
     * 奖品设置ID
     */
    @Column(name = "PRISE_ID")
    private String priseId;

    @Column(name = "RULE_ID")
    private String ruleId;

    /**
     * 失效时间
     */
    @Column(name = "EXPIRED_TIME")
    private Date expiredTime;

    /**
     * 生效时间
     */
    @Column(name = "EFFECTIVED_TIME")
    private Date effectivedTime;

    @Column(name = "PARENT_ID")
    private String parentId;

    /**
     * 标题
     */
    @Column(name = "TITLE")
    private String title;

    /**
     * 活动内容
     */
    @Column(name = "CONTENT")
    private String content;

    /**
     * 活动目的
     */
    @Column(name = "DESTINATION")
    private String destination;

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
     * 获取活动模板ID
     *
     * @return TEMPLATE_ID - 活动模板ID
     */
    public String getTemplateId() {
        return templateId;
    }

    /**
     * 设置活动模板ID
     *
     * @param templateId 活动模板ID
     */
    public void setTemplateId(String templateId) {
        this.templateId = templateId == null ? null : templateId.trim();
    }

    /**
     * 获取奖品设置ID
     *
     * @return PRISE_ID - 奖品设置ID
     */
    public String getPriseId() {
        return priseId;
    }

    /**
     * 设置奖品设置ID
     *
     * @param priseId 奖品设置ID
     */
    public void setPriseId(String priseId) {
        this.priseId = priseId == null ? null : priseId.trim();
    }

    /**
     * @return RULE_ID
     */
    public String getRuleId() {
        return ruleId;
    }

    /**
     * @param ruleId
     */
    public void setRuleId(String ruleId) {
        this.ruleId = ruleId == null ? null : ruleId.trim();
    }

    /**
     * 获取失效时间
     *
     * @return EXPIRED_TIME - 失效时间
     */
    public Date getExpiredTime() {
        return expiredTime;
    }

    /**
     * 设置失效时间
     *
     * @param expiredTime 失效时间
     */
    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }

    /**
     * 获取生效时间
     *
     * @return EFFECTIVED_TIME - 生效时间
     */
    public Date getEffectivedTime() {
        return effectivedTime;
    }

    /**
     * 设置生效时间
     *
     * @param effectivedTime 生效时间
     */
    public void setEffectivedTime(Date effectivedTime) {
        this.effectivedTime = effectivedTime;
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

    /**
     * 获取标题
     *
     * @return TITLE - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取活动内容
     *
     * @return CONTENT - 活动内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置活动内容
     *
     * @param content 活动内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 获取活动目的
     *
     * @return DESTINATION - 活动目的
     */
    public String getDestination() {
        return destination;
    }

    /**
     * 设置活动目的
     *
     * @param destination 活动目的
     */
    public void setDestination(String destination) {
        this.destination = destination == null ? null : destination.trim();
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
        Activity other = (Activity) that;
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
            && (this.getTemplateId() == null ? other.getTemplateId() == null : this.getTemplateId().equals(other.getTemplateId()))
            && (this.getPriseId() == null ? other.getPriseId() == null : this.getPriseId().equals(other.getPriseId()))
            && (this.getRuleId() == null ? other.getRuleId() == null : this.getRuleId().equals(other.getRuleId()))
            && (this.getExpiredTime() == null ? other.getExpiredTime() == null : this.getExpiredTime().equals(other.getExpiredTime()))
            && (this.getEffectivedTime() == null ? other.getEffectivedTime() == null : this.getEffectivedTime().equals(other.getEffectivedTime()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getDestination() == null ? other.getDestination() == null : this.getDestination().equals(other.getDestination()));
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
        result = prime * result + ((getTemplateId() == null) ? 0 : getTemplateId().hashCode());
        result = prime * result + ((getPriseId() == null) ? 0 : getPriseId().hashCode());
        result = prime * result + ((getRuleId() == null) ? 0 : getRuleId().hashCode());
        result = prime * result + ((getExpiredTime() == null) ? 0 : getExpiredTime().hashCode());
        result = prime * result + ((getEffectivedTime() == null) ? 0 : getEffectivedTime().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getDestination() == null) ? 0 : getDestination().hashCode());
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
        sb.append(", templateId=").append(templateId);
        sb.append(", priseId=").append(priseId);
        sb.append(", ruleId=").append(ruleId);
        sb.append(", expiredTime=").append(expiredTime);
        sb.append(", effectivedTime=").append(effectivedTime);
        sb.append(", parentId=").append(parentId);
        sb.append(", title=").append(title);
        sb.append(", content=").append(content);
        sb.append(", destination=").append(destination);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}