package com.zwo.pls.modules.system.service.impl;

import com.zwo.pls.core.service.impl.BaseServiceImpl;
import com.zwo.pls.modules.mem.service.impl.MemberServiceImpl;
import com.zwo.pls.modules.system.domain.User;
import com.zwo.pls.modules.system.mapper.UserMapper;
import com.zwo.pls.modules.system.service.IUserService;
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
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {

    private static Logger logger= LoggerFactory.getLogger(MemberServiceImpl.class);
    private static final String MESSAGE = "系统用户增删改查";

    @Autowired
    private UserMapper userMapper;

    @Override
    protected Mapper<User> getBaseMapper() {
        return userMapper;
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
