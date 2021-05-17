package com.hjx.webmaker.modules.core.mapper;

import com.hjx.webmaker.modules.core.domain.Channel;
import com.hjx.webmaker.modules.core.domain.ChannelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChannelMapper {
    long countByExample(ChannelCriteria example);

    int deleteByExample(ChannelCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(Channel record);

    int insertSelective(Channel record);

    List<Channel> selectByExample(ChannelCriteria example);

    Channel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Channel record, @Param("example") ChannelCriteria example);

    int updateByExample(@Param("record") Channel record, @Param("example") ChannelCriteria example);

    int updateByPrimaryKeySelective(Channel record);

    int updateByPrimaryKey(Channel record);
}