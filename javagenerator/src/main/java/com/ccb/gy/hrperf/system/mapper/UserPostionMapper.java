package com.ccb.gy.hrperf.system.mapper;

import com.ccb.gy.hrperf.system.domain.UserPostion;
import com.ccb.gy.hrperf.system.domain.UserPostionCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface UserPostionMapper extends Mapper<UserPostion> {
    long countByExample(UserPostionCriteria example);

    int deleteByExample(UserPostionCriteria example);

    List<UserPostion> selectByExample(UserPostionCriteria example);

    int updateByExampleSelective(@Param("record") UserPostion record, @Param("example") UserPostionCriteria example);

    int updateByExample(@Param("record") UserPostion record, @Param("example") UserPostionCriteria example);
}