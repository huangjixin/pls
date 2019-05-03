package com.zwo.pls.modules.system.mapper;

import com.zwo.pls.modules.system.domain.User;
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
    User selectByUserName(@Param(value = "loginName") String loginName);

    /**
     * 批量插入用户。
     * @param users
     * @return
     */
    int insertBatch(@Param(value = "users")List<User> users);
}