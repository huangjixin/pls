package com.hjx.elecfile.modules.sys.dao;

import com.hjx.elecfile.modules.sys.domain.SysUserRole;
import com.hjx.elecfile.modules.sys.domain.SysUserRoleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserRoleMapper {
    long countByExample(SysUserRoleCriteria example);

    int deleteByExample(SysUserRoleCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    List<SysUserRole> selectByExample(SysUserRoleCriteria example);

    SysUserRole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysUserRole record, @Param("example") SysUserRoleCriteria example);

    int updateByExample(@Param("record") SysUserRole record, @Param("example") SysUserRoleCriteria example);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);
}