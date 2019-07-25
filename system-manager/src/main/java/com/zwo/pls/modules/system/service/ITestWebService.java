package com.zwo.pls.modules.system.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 一句话描述该类功能：测试 Web Service。
 * Created by Tony(黄记新) in 2019/7/24
 * 命名空间,一般是接口的包名倒序
 */
@WebService(targetNamespace = "http://service.system.modules.pls.zwo.com")
public interface ITestWebService {
    @WebMethod
    public String test(@WebParam(name = "id") String id);
}
