package com.ccb.gy.hrperf.system.mapper;

import com.ccb.gy.hrperf.system.domain.Postion;
import com.ccb.gy.hrperf.system.domain.PostionCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface PostionMapper extends Mapper<Postion> {
    long countByExample(PostionCriteria example);

    int deleteByExample(PostionCriteria example);

    List<Postion> selectByExample(PostionCriteria example);

    int updateByExampleSelective(@Param("record") Postion record, @Param("example") PostionCriteria example);

    int updateByExample(@Param("record") Postion record, @Param("example") PostionCriteria example);
}