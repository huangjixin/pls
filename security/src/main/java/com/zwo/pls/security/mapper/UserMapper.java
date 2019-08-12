package com.zwo.pls.security.mapper;

import com.zwo.pls.security.domain.User;
import com.zwo.pls.security.domain.UserCriteria;
import com.zwo.pls.security.dto.UserDto;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    /**
     * 根据用户名查询用户信息（带有权限列表）
     *
     * @param loginName 用户名
     * @return User
     */
    UserDto selectByUserName(@Param(value = "loginName") String loginName);
}