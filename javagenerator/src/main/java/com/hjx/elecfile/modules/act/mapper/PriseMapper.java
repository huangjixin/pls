package com.hjx.elecfile.modules.act.mapper;

import com.hjx.elecfile.modules.act.domain.Prise;
import com.hjx.elecfile.modules.act.domain.PriseCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface PriseMapper extends Mapper<Prise> {
    long countByExample(PriseCriteria example);

    int deleteByExample(PriseCriteria example);

    List<Prise> selectByExample(PriseCriteria example);

    int updateByExampleSelective(@Param("record") Prise record, @Param("example") PriseCriteria example);

    int updateByExample(@Param("record") Prise record, @Param("example") PriseCriteria example);
}