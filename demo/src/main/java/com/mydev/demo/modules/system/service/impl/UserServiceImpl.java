package com.mydev.demo.modules.system.service.impl;

import com.mydev.demo.modules.system.domain.User;
import com.mydev.demo.modules.system.domain.UserCriteria;
import com.mydev.demo.modules.system.mapper.UserMapper;
import com.mydev.demo.modules.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public long countByExample(UserCriteria example) {
        return userMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(UserCriteria example) {
        return userMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String username) {
        return userMapper.deleteByPrimaryKey(username);
    }

    @Override
    public int insert(User record) {
        String pwd = record.getPassword();
        if (!StringUtils.isEmpty(pwd)) {
            pwd = DigestUtils.md5DigestAsHex(pwd.getBytes());
            record.setPassword(pwd);
        }
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        String pwd = record.getPassword();
        if (!StringUtils.isEmpty(pwd)) {
            pwd = DigestUtils.md5DigestAsHex(pwd.getBytes());
            record.setPassword(pwd);
        }
        return userMapper.insertSelective(record);
    }

    @Override
    public List<User> selectByExample(UserCriteria example) {
        return userMapper.selectByExample(example);
    }

    @Override
    public User selectByPrimaryKey(String username) {
        return userMapper.selectByPrimaryKey(username);
    }

    @Override
    public int updateByExampleSelective(User record, UserCriteria example) {
        return userMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(User record, UserCriteria example) {
        return userMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        String pwd = record.getPassword();
        if (!StringUtils.isEmpty(pwd)) {
            pwd = DigestUtils.md5DigestAsHex(pwd.getBytes());
            record.setPassword(pwd);
        }
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        String pwd = record.getPassword();
        if (!StringUtils.isEmpty(pwd)) {
            pwd = DigestUtils.md5DigestAsHex(pwd.getBytes());
            record.setPassword(pwd);
        }
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public Boolean validateUser(String username, String pwd) {
        User user = this.userMapper.selectByPrimaryKey(username);
        if (StringUtils.isEmpty(user)) {
            return false;
        }
        String password = user.getPassword();
        pwd = DigestUtils.md5DigestAsHex(pwd.getBytes());

        return password.equals(pwd);
    }
}
