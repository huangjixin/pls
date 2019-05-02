package com.zwo.pls.modules.mem.mapper;

import com.zwo.pls.modules.mem.domain.Member;
import com.zwo.pls.modules.mem.domain.MemberCriteria;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MemberMapper extends Mapper<Member> {
    long countByExample(MemberCriteria example);

    int deleteByExample(MemberCriteria example);

    List<Member> selectByExample(MemberCriteria example);

    int updateByExampleSelective(@Param("record") Member record, @Param("example") MemberCriteria example);

    int updateByExample(@Param("record") Member record, @Param("example") MemberCriteria example);
}