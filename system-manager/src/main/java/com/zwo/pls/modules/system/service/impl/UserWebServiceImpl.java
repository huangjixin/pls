package com.zwo.pls.modules.system.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zwo.pls.modules.system.domain.User;
import com.zwo.pls.modules.system.mapper.UserMapper;
import com.zwo.pls.modules.system.service.IUserWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

/**
 * 一句话描述该类功能：
 * Created by Tony(黄记新) in 2019/7/25
 */
@WebService(name = "userWebService", // 暴露服务名称
        targetNamespace = "http://service.system.modules.pls.zwo.com",// 命名空间,一般是接口的包名倒序
        endpointInterface = "com.zwo.pls.modules.system.service.IUserWebService"// 包名
)
@Component
public class UserWebServiceImpl implements IUserWebService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public String getUser(String id) {
        String result =  "";
        User user = this.userMapper.selectByPrimaryKey(id);
        if(user !=null){
            result = JSONObject.toJSONString(user);
        }

        return result;
    }
}
