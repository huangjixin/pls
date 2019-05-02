package com.zwo.pls.modules.mem.mapper;

import com.zwo.pls.modules.mem.domain.Postion;
import com.zwo.pls.modules.mem.domain.PostionCriteria;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PostionMapper extends Mapper<Postion> {
    long countByExample(PostionCriteria example);

    int deleteByExample(PostionCriteria example);

    List<Postion> selectByExample(PostionCriteria example);

    int updateByExampleSelective(@Param("record") Postion record, @Param("example") PostionCriteria example);

    int updateByExample(@Param("record") Postion record, @Param("example") PostionCriteria example);
}