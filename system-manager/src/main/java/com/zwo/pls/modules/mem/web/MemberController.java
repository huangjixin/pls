package com.zwo.pls.modules.mem.web;

import com.zwo.pls.core.service.IBaseService;
import com.zwo.pls.core.web.BaseController;
import com.zwo.pls.modules.mem.domain.Member;
import com.zwo.pls.modules.mem.service.IMemberService;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class MemberController extends BaseController {
    @Autowired
    private IMemberService memberService;

    @Override
    protected IBaseService getBaseService() {
        return memberService;
    }

    @GetMapping("test")
    public Member test(){
        Member user = memberService.selectByPrimaryKey("1");
        return  user;
    }

    /**
     * 下载Excel。
     * @param request
     * @param response
     */
    @Override
    @GetMapping(value = {"download-excel"})
    public void downloadTemplateFile(HttpServletRequest request, HttpServletResponse response) {
        InputStream is = null;
        OutputStream os = null;
        try {
            response.setCharacterEncoding(request.getCharacterEncoding());
            response.setContentType("application/octet-stream");
            ClassPathResource resource = new ClassPathResource("public/excel-template/member_import.xls");
            response.setHeader("Content-Disposition", "attachment; filename=" + resource.getFilename());
            is = resource.getInputStream();
            os = response.getOutputStream();
            IOUtils.copy(is, os);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(is != null){
                try {
                    is.close();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
            if(os != null){
                try {
                    os.close();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }
    }

}
