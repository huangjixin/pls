package com.hjx.webmaker.modules.sys.mapper;

import com.hjx.webmaker.modules.sys.domain.RolePermission;
import com.hjx.webmaker.modules.sys.domain.RolePermissionCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolePermissionMapper {
    long countByExample(RolePermissionCriteria example);

    int deleteByExample(RolePermissionCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    List<RolePermission> selectByExample(RolePermissionCriteria example);

    RolePermission selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RolePermission record, @Param("example") RolePermissionCriteria example);

    int updateByExample(@Param("record") RolePermission record, @Param("example") RolePermissionCriteria example);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);
}