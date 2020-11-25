package com.hjx.elecfile.modules.sys.dao;

import com.hjx.elecfile.modules.sys.domain.SysRolePermission;
import com.hjx.elecfile.modules.sys.domain.SysRolePermissionCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRolePermissionMapper {
    long countByExample(SysRolePermissionCriteria example);

    int deleteByExample(SysRolePermissionCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);

    List<SysRolePermission> selectByExample(SysRolePermissionCriteria example);

    SysRolePermission selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysRolePermission record, @Param("example") SysRolePermissionCriteria example);

    int updateByExample(@Param("record") SysRolePermission record, @Param("example") SysRolePermissionCriteria example);

    int updateByPrimaryKeySelective(SysRolePermission record);

    int updateByPrimaryKey(SysRolePermission record);
}