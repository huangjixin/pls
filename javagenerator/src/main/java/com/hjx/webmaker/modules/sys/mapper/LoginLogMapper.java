package com.hjx.webmaker.modules.sys.mapper;

import com.hjx.webmaker.modules.sys.domain.LoginLog;
import com.hjx.webmaker.modules.sys.domain.LoginLogCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LoginLogMapper {
    long countByExample(LoginLogCriteria example);

    int deleteByExample(LoginLogCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(LoginLog record);

    int insertSelective(LoginLog record);

    List<LoginLog> selectByExample(LoginLogCriteria example);

    LoginLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") LoginLog record, @Param("example") LoginLogCriteria example);

    int updateByExample(@Param("record") LoginLog record, @Param("example") LoginLogCriteria example);

    int updateByPrimaryKeySelective(LoginLog record);

    int updateByPrimaryKey(LoginLog record);
}