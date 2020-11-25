package com.hjx.elecfile.modules.sys.dao;

import com.hjx.elecfile.modules.sys.domain.SysPermission;
import com.hjx.elecfile.modules.sys.domain.SysPermissionCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysPermissionMapper {
    long countByExample(SysPermissionCriteria example);

    int deleteByExample(SysPermissionCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    List<SysPermission> selectByExample(SysPermissionCriteria example);

    SysPermission selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysPermission record, @Param("example") SysPermissionCriteria example);

    int updateByExample(@Param("record") SysPermission record, @Param("example") SysPermissionCriteria example);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);
}