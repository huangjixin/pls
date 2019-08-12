package com.zwo.pls.modules.mem.web;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.zwo.pls.core.service.IBaseService;
import com.zwo.pls.core.vo.Message;
import com.zwo.pls.core.web.BaseController;
import com.zwo.pls.modules.mem.domain.Member;
import com.zwo.pls.modules.mem.service.IMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

/**
 * 一句话描述该类功能：
 * Created by Tony(黄记新) in 2019/4/30
 */
@Api(value = "member", tags="会员用户增删改查")
@RestController
@RequestMapping("member")
public class MemberController extends BaseController<Member> {
    @Autowired
    private IMemberService memberService;

    @Override
    protected IBaseService getBaseService() {
        return memberService;
    }

    /**
     * @param id
     * @param request
     * @param response
     * @return
     */
    @ApiOperation(value = "根据ID查询记录",notes = "根据ID查询记录",response = Message.class)
    @Override
    @GetMapping(value = {"/{id}"})
    public Message getById(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response){
        Message message = new Message();
        Member result = (Member) this.getBaseService().selectByPrimaryKey(id);
        if(result == null){
            message.setCode(HttpStatus.NOT_FOUND.value()+"");
            message.setMsg("查询不到");
        }
        message.setData(result);
        return  message;
    }

    /**
     * 新增记录
     * @param record
     * @return
     */
//    @ApiImplicitParam(name = "record",value = "用户详细实体")
    @ApiOperation(value = "新增记录",notes = "根据实体对象新增记录",response = Message.class)
    @Override
    @PostMapping
    public Message insert(@RequestBody Member record, HttpServletRequest request, HttpServletResponse response) {
        Message message = new Message();
        if(StringUtils.isEmpty(record.getId())){
            record.setId(UUID.randomUUID().toString().replaceAll("-",""));
        }
        int result = this.getBaseService().insertSelective(record);
        message.setData(result);
        return  message;
    }

    /**
     * 更新记录
     * @param id
     * @param record
     * @return
     */
//    @ApiImplicitParam(name = "record",value = "用户详细实体")
    @ApiOperation(value = "更新记录",notes = "更新记录",response = Message.class)
    @Override
    @PutMapping(value = {"/{id}"})
    public Message update(@PathVariable("id") String id, @RequestBody Member record, HttpServletRequest request, HttpServletResponse response){
        Message message = new Message();
        int result = this.getBaseService().updateByPrimaryKeySelective(record);
        if(result == 0){
            message.setCode("400");
            message.setMsg("修改失败");
        }
        return  message;
    }

    /**
     * 删除记录。
     * @param id
     * @return
     */
//    @ApiImplicitParam(name = "id",value = "ID唯一标识符")
    @ApiOperation(value = "删除记录",notes = "删除记录",response = Message.class)
    @Override
    @DeleteMapping(value = {"/{id}"})
    public Message delete(@PathVariable("id") String id,HttpServletRequest request,HttpServletResponse response) {
        Message message = new Message();
        int result = this.getBaseService().deleteByPrimaryKey(id);
        if(result == 0){
            message.setCode("400");
            message.setMsg("修改失败");
        }
        return  message;
    }

    @ApiOperation(value = "列表记录分页",notes = "列表记录分页",response = Message.class)
    @Override
    @GetMapping("list")
    public Message list(HttpServletRequest request,HttpServletResponse response,@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                        @RequestParam(required = false, defaultValue = "50") Integer pageSize) {
        Message message = new Message();
        PageInfo pageInfo =  this.getBaseService().selectByExample(null,pageNum,pageSize);
        message.setData(pageInfo);
        return  message;
    }

    /**
     * 默认查询所有列表。
     * @param request
     * @return
     */
    @ApiOperation(value = "默认查询所有列表",notes = "默认查询所有列表",response = Message.class)
    @Override
    @GetMapping
    public Message listAll(HttpServletRequest request,HttpServletResponse response) {
        Message message = new Message();
        List list = this.getBaseService().selectByExample(null);
        message.setData(list);
        return  message;
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
