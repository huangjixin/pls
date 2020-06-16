package com.mydev.demo.modules.system.service;

import com.mydev.demo.modules.system.domain.User;
import com.mydev.demo.modules.system.domain.UserCriteria;

import java.util.List;

public interface IUserService {
    long countByExample(UserCriteria example);

    int deleteByExample(UserCriteria example);

    int deleteByPrimaryKey(String username);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserCriteria example);

    User selectByPrimaryKey(String username);

    int updateByExampleSelective(User record, UserCriteria example);

    int updateByExample(User record, UserCriteria example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    Boolean validateUser(String username, String password);
}
