package com.hjx.webmaker.modules.core.mapper;

import com.hjx.webmaker.modules.core.domain.Attachment;
import com.hjx.webmaker.modules.core.domain.AttachmentCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttachmentMapper {
    long countByExample(AttachmentCriteria example);

    int deleteByExample(AttachmentCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(Attachment record);

    int insertSelective(Attachment record);

    List<Attachment> selectByExample(AttachmentCriteria example);

    Attachment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Attachment record, @Param("example") AttachmentCriteria example);

    int updateByExample(@Param("record") Attachment record, @Param("example") AttachmentCriteria example);

    int updateByPrimaryKeySelective(Attachment record);

    int updateByPrimaryKey(Attachment record);
}