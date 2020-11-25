package com.hjx.elecfile.modules.sys.dao;

import com.hjx.elecfile.modules.sys.domain.SysOpeLog;
import com.hjx.elecfile.modules.sys.domain.SysOpeLogCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysOpeLogMapper {
    long countByExample(SysOpeLogCriteria example);

    int deleteByExample(SysOpeLogCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(SysOpeLog record);

    int insertSelective(SysOpeLog record);

    List<SysOpeLog> selectByExample(SysOpeLogCriteria example);

    SysOpeLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysOpeLog record, @Param("example") SysOpeLogCriteria example);

    int updateByExample(@Param("record") SysOpeLog record, @Param("example") SysOpeLogCriteria example);

    int updateByPrimaryKeySelective(SysOpeLog record);

    int updateByPrimaryKey(SysOpeLog record);
}