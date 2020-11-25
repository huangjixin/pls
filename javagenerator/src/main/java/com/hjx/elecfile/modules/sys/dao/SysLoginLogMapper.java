package com.hjx.elecfile.modules.sys.dao;

import com.hjx.elecfile.modules.sys.domain.SysLoginLog;
import com.hjx.elecfile.modules.sys.domain.SysLoginLogCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysLoginLogMapper {
    long countByExample(SysLoginLogCriteria example);

    int deleteByExample(SysLoginLogCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(SysLoginLog record);

    int insertSelective(SysLoginLog record);

    List<SysLoginLog> selectByExample(SysLoginLogCriteria example);

    SysLoginLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysLoginLog record, @Param("example") SysLoginLogCriteria example);

    int updateByExample(@Param("record") SysLoginLog record, @Param("example") SysLoginLogCriteria example);

    int updateByPrimaryKeySelective(SysLoginLog record);

    int updateByPrimaryKey(SysLoginLog record);
}