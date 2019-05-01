package com.zwo.pls.security.service.impl;

import com.zwo.pls.security.domain.User;
import com.zwo.pls.security.dto.UserDto;
import com.zwo.pls.security.mapper.UserMapper;
import com.zwo.pls.security.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 一句话描述该类功能：
 * Created by Tony(黄记新) in 2019/4/27
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService {
   private static Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);

   @Autowired
   private UserMapper userMapper;

   public User selectByUserName(String loginName){
       User user = userMapper.selectByUserName(loginName);
       return  user;
   }
}
