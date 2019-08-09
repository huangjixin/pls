package com.zwo.pls.modules.mem.web;

import com.alibaba.fastjson.JSONObject;
import com.zwo.pls.core.service.IBaseService;
import com.zwo.pls.core.web.BaseController;
import com.zwo.pls.modules.mem.domain.Member;
import com.zwo.pls.modules.mem.service.IMemberService;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 一句话描述该类功能：
 * Created by Tony(黄记新) in 2019/4/30
 */
@RestController
@RequestMapping("member")
public class MemberController extends BaseController<Member> {
    @Autowired
    private IMemberService memberService;

    @Override
    protected IBaseService getBaseService() {
        return memberService;
    }

    @GetMapping("test")
    public Member test(@RequestHeader(value="Authorization") String authorization){
        String[] array = authorization.split(" ");
        String token = array[1];
        Jwt jwt = JwtHelper.decode(token);
        System.out.println(jwt.getClaims());
        JSONObject jsonObject = JSONObject.parseObject( jwt.getClaims());
        System.out.println(jsonObject.get("user"));
        Member user = memberService.selectByPrimaryKey("1");
        return  user;
    }


}
