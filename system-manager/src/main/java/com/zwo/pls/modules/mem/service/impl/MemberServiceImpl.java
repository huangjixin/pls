package com.zwo.pls.modules.mem.service.impl;

import com.zwo.pls.core.service.impl.BaseServiceImpl;
import com.zwo.pls.modules.mem.domain.Member;
import com.zwo.pls.modules.mem.mapper.MemberMapper;
import com.zwo.pls.modules.mem.service.IMemberService;
import com.zwo.pls.modules.system.domain.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

/**
 * 一句话描述该类功能：
 * Created by Tony(黄记新) in 2019/5/2
 */
@Service
@Transactional
public class MemberServiceImpl extends BaseServiceImpl<Member> implements IMemberService {

    private static Logger logger= LoggerFactory.getLogger(MemberServiceImpl.class);
    private static final String MESSAGE = "用户增删改查";

    @Autowired
    private MemberMapper memberMapper;

    @Override
    protected Mapper<Member> getBaseMapper() {
        return memberMapper;
    }

    @Override
    protected String getBaseMessage() {
        return MESSAGE;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }
}
