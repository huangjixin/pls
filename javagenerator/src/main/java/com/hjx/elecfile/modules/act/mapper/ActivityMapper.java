package com.hjx.elecfile.modules.act.mapper;

import com.hjx.elecfile.modules.act.domain.Activity;
import com.hjx.elecfile.modules.act.domain.ActivityCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface ActivityMapper extends Mapper<Activity> {
    long countByExample(ActivityCriteria example);

    int deleteByExample(ActivityCriteria example);

    List<Activity> selectByExample(ActivityCriteria example);

    int updateByExampleSelective(@Param("record") Activity record, @Param("example") ActivityCriteria example);

    int updateByExample(@Param("record") Activity record, @Param("example") ActivityCriteria example);
}