1.添加pom.xml文件依赖：
<!--集成web service-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web-services</artifactId>
        </dependency>
        <dependency>
            <groupId>org.apache.cxf</groupId>
            <artifactId>cxf-spring-boot-starter-jaxws</artifactId>
            <version>3.3.2</version>
        </dependency>
 父亲pom.xml文件要降低版本：
<parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.0.1.RELEASE</version><!--用该低版本是为了兼容web service-->
        <!--<version>2.0.5.RELEASE</version>-->
        <!--<version>2.1.4.RELEASE</version>-->
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

2.添加配置：CxfConfig
package com.zwo.pls.config;

import com.zwo.pls.modules.system.service.ITestWebService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class CxfConfig {

    @Autowired
    private Bus bus;
    @Autowired
    private ITestWebService testWebService;

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus,testWebService);
        endpoint.publish("/testWebService");//接口发布在目录下

        //通过拦截器校验用户名与密码
        endpoint.getInInterceptors().add(new AuthInterceptor());
        return endpoint;
    }

    @Bean
    public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/cxf/*");
    }
}

3.编写接口和实现类：
package com.zwo.pls.modules.system.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 一句话描述该类功能：测试 Web Service。
 * Created by Tony(黄记新) in 2019/7/24
 */
@WebService(targetNamespace = "http://service.system.modules.pls.zwo.com"// 命名空间,一般是接口的包名倒序
)
public interface ITestWebService {
    @WebMethod
    public String test(@WebParam(name = "id") String id);
}


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

4.编写客户端测试文件：
package com.zwo.pls.modules.system;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

/**
 * 一句话描述该类功能：
 * Created by Tony(黄记新) in 2019/7/24
 */
public class TestWebService {
    public static void main(String[] args) {
        //创建动态客户端
        JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
        Client client = factory.createClient("http://localhost:9999/cxf/testWebService?wsdl");
        // 需要密码的情况需要加上用户名和密码
        client.getOutInterceptors().add(new ClientLoginInterceptor("admin","pass"));
        HTTPConduit conduit = (HTTPConduit) client.getConduit();
        HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
        httpClientPolicy.setConnectionTimeout(2000);  //连接超时
        httpClientPolicy.setAllowChunking(false);    //取消块编码
        httpClientPolicy.setReceiveTimeout(120000);     //响应超时
        conduit.setClient(httpClientPolicy);
        //client.getOutInterceptors().addAll(interceptors);//设置拦截器
        try {
            Object[] objects = new Object[0];
            // invoke("方法名",参数1,参数2,参数3....);
            objects = client.invoke("test", "test");
            System.out.println("返回数据:" + objects[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
