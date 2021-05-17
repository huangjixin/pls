package com.hjx.webmaker.modules.sys.mapper;

import com.hjx.webmaker.modules.sys.domain.Message;
import com.hjx.webmaker.modules.sys.domain.MessageCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageMapper {
    long countByExample(MessageCriteria example);

    int deleteByExample(MessageCriteria example);

    int insert(Message record);

    int insertSelective(Message record);

    List<Message> selectByExample(MessageCriteria example);

    int updateByExampleSelective(@Param("record") Message record, @Param("example") MessageCriteria example);

    int updateByExample(@Param("record") Message record, @Param("example") MessageCriteria example);
}