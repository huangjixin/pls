package com.zwo.pls.modules.mem.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "mem_member_position")
public class MemberPosition implements Serializable {
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "MEMBER_ID")
    private String memberId;

    @Column(name = "POSTION_ID")
    private String postionId;

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
     * @return MEMBER_ID
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * @param memberId
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    /**
     * @return POSTION_ID
     */
    public String getPostionId() {
        return postionId;
    }

    /**
     * @param postionId
     */
    public void setPostionId(String postionId) {
        this.postionId = postionId == null ? null : postionId.trim();
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
        MemberPosition other = (MemberPosition) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
            && (this.getPostionId() == null ? other.getPostionId() == null : this.getPostionId().equals(other.getPostionId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
        result = prime * result + ((getPostionId() == null) ? 0 : getPostionId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", memberId=").append(memberId);
        sb.append(", postionId=").append(postionId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}