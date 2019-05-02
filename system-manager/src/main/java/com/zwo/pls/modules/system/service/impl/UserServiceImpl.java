package com.zwo.pls.modules.system.service.impl;

import com.zwo.pls.core.service.impl.BaseServiceImpl;
import com.zwo.pls.modules.system.domain.User;
import com.zwo.pls.modules.system.service.IUserService;
import org.apache.logging.log4j.Logger;
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
    @Override
    protected Mapper<User> getBaseMapper() {
        return null;
    }

    @Override
    protected String getBaseMessage() {
        return null;
    }

    @Override
    protected Logger getLogger() {
        return null;
    }
}
