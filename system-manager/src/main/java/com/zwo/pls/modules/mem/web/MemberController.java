package com.zwo.pls.modules.mem.web;

import com.zwo.pls.core.web.BaseController;
import com.zwo.pls.modules.mem.service.IMemberService;
import com.zwo.pls.modules.system.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 一句话描述该类功能：
 * Created by Tony(黄记新) in 2019/4/30
 */
@RestController
@RequestMapping("member")
public class MemberController extends BaseController {
    @Autowired
    private IMemberService memberService;

    @GetMapping("test")
    public User test(){
        User user = memberService.selectByPrimaryKey("1");
        return  user;
    }
}
