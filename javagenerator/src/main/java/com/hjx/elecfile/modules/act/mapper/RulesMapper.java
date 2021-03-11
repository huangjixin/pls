package com.hjx.elecfile.modules.act.mapper;

import com.hjx.elecfile.modules.act.domain.Rules;
import com.hjx.elecfile.modules.act.domain.RulesCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface RulesMapper extends Mapper<Rules> {
    long countByExample(RulesCriteria example);

    int deleteByExample(RulesCriteria example);

    List<Rules> selectByExample(RulesCriteria example);

    int updateByExampleSelective(@Param("record") Rules record, @Param("example") RulesCriteria example);

    int updateByExample(@Param("record") Rules record, @Param("example") RulesCriteria example);
}