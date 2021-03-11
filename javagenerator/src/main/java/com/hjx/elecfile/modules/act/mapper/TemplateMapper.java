package com.hjx.elecfile.modules.act.mapper;

import com.hjx.elecfile.modules.act.domain.Template;
import com.hjx.elecfile.modules.act.domain.TemplateCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface TemplateMapper extends Mapper<Template> {
    long countByExample(TemplateCriteria example);

    int deleteByExample(TemplateCriteria example);

    List<Template> selectByExample(TemplateCriteria example);

    int updateByExampleSelective(@Param("record") Template record, @Param("example") TemplateCriteria example);

    int updateByExample(@Param("record") Template record, @Param("example") TemplateCriteria example);
}