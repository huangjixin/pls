package com.zwo.pls.modules.system.service.impl;

import com.zwo.pls.modules.system.service.ITestWebService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.Date;

/**
 * 一句话描述该类功能：
 * Created by Tony(黄记新) in 2019/7/24
 */
@WebService(name = "testWebService", // 暴露服务名称
        targetNamespace = "http://service.system.modules.pls.zwo.com",// 命名空间,一般是接口的包名倒序
        endpointInterface = "com.zwo.pls.modules.system.service.ITestWebService"// 包名
)
@Component
public class TestWebServiceImpl implements ITestWebService {
    @Override
    public String test(String id) {
        return id+"，现在时间："+"("+new Date()+")";
    }
}
