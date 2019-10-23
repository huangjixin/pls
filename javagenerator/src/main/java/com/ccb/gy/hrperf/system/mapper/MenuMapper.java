package com.ccb.gy.hrperf.system.mapper;

import com.ccb.gy.hrperf.system.domain.Menu;
import com.ccb.gy.hrperf.system.domain.MenuCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface MenuMapper extends Mapper<Menu> {
    long countByExample(MenuCriteria example);

    int deleteByExample(MenuCriteria example);

    List<Menu> selectByExample(MenuCriteria example);

    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuCriteria example);

    int updateByExample(@Param("record") Menu record, @Param("example") MenuCriteria example);
}