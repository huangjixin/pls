package com.hjx.elecfile.modules.sys.dao;

import com.hjx.elecfile.modules.sys.domain.PermissionMenu;
import com.hjx.elecfile.modules.sys.domain.PermissionMenuCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissionMenuMapper {
    long countByExample(PermissionMenuCriteria example);

    int deleteByExample(PermissionMenuCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(PermissionMenu record);

    int insertSelective(PermissionMenu record);

    List<PermissionMenu> selectByExample(PermissionMenuCriteria example);

    PermissionMenu selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PermissionMenu record, @Param("example") PermissionMenuCriteria example);

    int updateByExample(@Param("record") PermissionMenu record, @Param("example") PermissionMenuCriteria example);

    int updateByPrimaryKeySelective(PermissionMenu record);

    int updateByPrimaryKey(PermissionMenu record);
}