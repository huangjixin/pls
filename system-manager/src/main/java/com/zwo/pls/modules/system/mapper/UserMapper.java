package com.zwo.pls.modules.system.mapper;

import com.zwo.pls.security.domain.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {
    /**
     * 根据用户名查询用户信息（带有权限列表）
     *
     * @param loginName 用户名
     * @return User
     */
    User selectByUserName(@Param(value = "loginName") String loginName);
}