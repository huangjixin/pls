package com.mydev.demo.modules.system.web;

import com.alibaba.fastjson.JSONObject;
import com.mydev.demo.modules.system.domain.User;
import com.mydev.demo.modules.system.domain.UserCriteria;
import com.mydev.demo.modules.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping
    public String defaultIndex() {
        return "user/users";
    }

    @GetMapping("listPage")
    @ResponseBody
    public JSONObject listPage(@RequestParam(name = "page") Integer page, @RequestParam(name = "rows") Integer rows,
                               HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        UserCriteria example = this.getCriteria(httpServletRequest);
        example.setLimitStart((page - 1) * rows);
        example.setLimitSize(rows);
        List<User> list = this.userService.selectByExample(example);
        JSONObject jsonObject = new JSONObject();
        Long total = this.userService.countByExample(example);
        jsonObject.put("rows", list);
        jsonObject.put("total", total);
        return jsonObject;
    }

    private UserCriteria getCriteria(HttpServletRequest request) {
        UserCriteria example = new UserCriteria();
        if (request.getParameterNames().hasMoreElements()) {
            UserCriteria.Criteria criteria = example.createCriteria();
            String userame = request.getParameter("username");
            if (!StringUtils.isEmpty(userame)) {
                criteria.andUsernameLike("%" + userame + "%");
            }

            String sort = request.getParameter("sort");
            String sortOrder = request.getParameter("sortOrder");
            if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(sortOrder)) {
                if ("username".equals(sort)) {
                    sort = "username";
                }

                if ("createTime".equals(sort)) {
                    sort = "create_time";
                }

                if ("updateTime".equals(sort)) {
                    sort = "update_time";
                }

                example.setOrderByClause(sort + " " + sortOrder);
            }
        }
        return example;
    }
}
