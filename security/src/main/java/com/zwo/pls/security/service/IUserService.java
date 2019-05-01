package com.zwo.pls.security.service;

import com.zwo.pls.security.domain.User;
/**
 * 一句话描述该类功能：
 * Created by Tony(黄记新) in 2019/4/27
 */
public interface IUserService {
    /**
     * 根据用户名查询用户信息（带有权限列表）
     *
     * @param loginName 用户名
     * @return User
     */
    User selectByUserName(String loginName);
}
