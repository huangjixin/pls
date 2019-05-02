package com.zwo.pls.modules.mem.mapper;

import com.zwo.pls.modules.mem.domain.MemberPosition;
import com.zwo.pls.modules.mem.domain.MemberPositionCriteria;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MemberPositionMapper extends Mapper<MemberPosition> {
    long countByExample(MemberPositionCriteria example);

    int deleteByExample(MemberPositionCriteria example);

    List<MemberPosition> selectByExample(MemberPositionCriteria example);

    int updateByExampleSelective(@Param("record") MemberPosition record, @Param("example") MemberPositionCriteria example);

    int updateByExample(@Param("record") MemberPosition record, @Param("example") MemberPositionCriteria example);
}