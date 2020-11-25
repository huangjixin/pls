package com.hjx.elecfile.modules.sys.dao;

import com.hjx.elecfile.modules.sys.domain.SysRole;
import com.hjx.elecfile.modules.sys.domain.SysRoleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleMapper {
    long countByExample(SysRoleCriteria example);

    int deleteByExample(SysRoleCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    List<SysRole> selectByExample(SysRoleCriteria example);

    SysRole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysRole record, @Param("example") SysRoleCriteria example);

    int updateByExample(@Param("record") SysRole record, @Param("example") SysRoleCriteria example);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
}