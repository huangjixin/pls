package com.zwo.pls.modules.system.service;

import com.zwo.pls.core.service.IBaseService;
import com.zwo.pls.modules.system.domain.User;
import com.zwo.pls.modules.system.domain.UserCriteria;
import com.zwo.pls.modules.system.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 一句话描述该类功能：
 * Created by Tony(黄记新) in 2019/5/2
 */
public interface IUserService extends IBaseService<User> {
    /**
     * 根据用户名查询用户信息（带有权限列表）
     *
     * @return UserVo
     */
    UserVo selectByUserName(String loginName);

    /**
     * 批量插入用户。
     * @param users
     * @return
     */
    int insertBatch(List<User> users);

    /**
     * 根据查询条件查询并且进行分页。
     * @param example
     * @param start
     * @param size
     * @return
     */
    List<UserVo> selectByExamplePage(UserCriteria example, Integer start, Integer size);
}
