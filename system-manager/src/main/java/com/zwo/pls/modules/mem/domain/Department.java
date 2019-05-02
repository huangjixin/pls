package com.zwo.pls.modules.mem.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "mem_department")
public class Department implements Serializable {
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "IS_EXPIRED")
    private Byte isExpired;

    @Column(name = "IS_LOCKED")
    private Byte isLocked;

    @Column(name = "IS_ENABLED")
    private Byte isEnabled;

    @Column(name = "TYPE")
    private Integer type;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "CREATE_BY")
    private String createBy;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "UPDATE_BY")
    private String updateBy;

    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    @Column(name = "EN_NAME")
    private String enName;

    /**
     * 父类ID
     */
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
     * @return NAME
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return IS_EXPIRED
     */
    public Byte getIsExpired() {
        return isExpired;
    }

    /**
     * @param isExpired
     */
    public void setIsExpired(Byte isExpired) {
        this.isExpired = isExpired;
    }

    /**
     * @return IS_LOCKED
     */
    public Byte getIsLocked() {
        return isLocked;
    }

    /**
     * @param isLocked
     */
    public void setIsLocked(Byte isLocked) {
        this.isLocked = isLocked;
    }

    /**
     * @return IS_ENABLED
     */
    public Byte getIsEnabled() {
        return isEnabled;
    }

    /**
     * @param isEnabled
     */
    public void setIsEnabled(Byte isEnabled) {
        this.isEnabled = isEnabled;
    }

    /**
     * @return TYPE
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return STATUS
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return CREATE_BY
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * @param createBy
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * @return CREATE_TIME
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return UPDATE_BY
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * @param updateBy
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * @return UPDATE_TIME
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return EN_NAME
     */
    public String getEnName() {
        return enName;
    }

    /**
     * @param enName
     */
    public void setEnName(String enName) {
        this.enName = enName == null ? null : enName.trim();
    }

    /**
     * 获取父类ID
     *
     * @return PARENT_ID - 父类ID
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置父类ID
     *
     * @param parentId 父类ID
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
        Department other = (Department) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getIsExpired() == null ? other.getIsExpired() == null : this.getIsExpired().equals(other.getIsExpired()))
            && (this.getIsLocked() == null ? other.getIsLocked() == null : this.getIsLocked().equals(other.getIsLocked()))
            && (this.getIsEnabled() == null ? other.getIsEnabled() == null : this.getIsEnabled().equals(other.getIsEnabled()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getEnName() == null ? other.getEnName() == null : this.getEnName().equals(other.getEnName()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getIsExpired() == null) ? 0 : getIsExpired().hashCode());
        result = prime * result + ((getIsLocked() == null) ? 0 : getIsLocked().hashCode());
        result = prime * result + ((getIsEnabled() == null) ? 0 : getIsEnabled().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getEnName() == null) ? 0 : getEnName().hashCode());
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
        sb.append(", name=").append(name);
        sb.append(", isExpired=").append(isExpired);
        sb.append(", isLocked=").append(isLocked);
        sb.append(", isEnabled=").append(isEnabled);
        sb.append(", type=").append(type);
        sb.append(", status=").append(status);
        sb.append(", createBy=").append(createBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", enName=").append(enName);
        sb.append(", parentId=").append(parentId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}