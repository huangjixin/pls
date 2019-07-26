package com.zwo.pls.config;

import com.zwo.pls.modules.system.service.ITestWebService;
import com.zwo.pls.modules.system.service.IUserWebService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

//@Configuration
public class CxfConfig {

    @Autowired
    private Bus bus;
    @Autowired
    private ITestWebService testWebService;
    @Autowired
    private IUserWebService userWebService;


    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus,testWebService);
        endpoint.publish("/testWebService");//接口发布在目录下
        //通过拦截器校验用户名与密码
//        endpoint.getInInterceptors().add(new AuthInterceptor());
        return endpoint;
    }

    @Bean
    public Endpoint endpoint2() {
        EndpointImpl endpoint = new EndpointImpl(bus,userWebService);
        endpoint.publish("/userWebService");//接口发布在目录下
        //通过拦截器校验用户名与密码
//        endpoint.getInInterceptors().add(new AuthInterceptor());
        return endpoint;
    }

    @Bean
    public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/cxf/*");
    }
}