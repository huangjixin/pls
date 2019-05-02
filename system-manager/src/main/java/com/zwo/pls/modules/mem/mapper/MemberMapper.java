package com.zwo.pls.modules.mem.mapper;

import com.zwo.pls.modules.mem.domain.Member;
import com.zwo.pls.modules.mem.domain.MemberCriteria;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MemberMapper extends Mapper<Member> {

}