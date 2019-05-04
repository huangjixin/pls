package com.zwo.pls.modules.system.mapper;

import com.github.pagehelper.PageInfo;
import com.zwo.pls.modules.system.domain.User;
import com.zwo.pls.modules.system.domain.UserCriteria;
import com.zwo.pls.modules.system.vo.UserVo;
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
    UserVo selectByUserName(@Param(value = "loginName") String loginName);

    /**
     * 批量插入用户。
     * @param users
     * @return
     */
    int insertBatch(@Param(value = "users")List<User> users);

    /**
     * 根据查询条件查询并且进行分页。
     * @param example
     * @return
     */
    List<UserVo> selectByExamplePage(@Param("example")UserCriteria example,@Param("start")Integer start,@Param("size")Integer size);
}