package com.zwo.pls.core.web;

import com.github.pagehelper.PageInfo;
import com.zwo.pls.core.service.IBaseService;
import com.zwo.pls.core.utils.ExcelUtil;
import com.zwo.pls.core.vo.Message;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * 基类控制器，将控制器行为做一个抽象
 *
 * @author Tony（黄记新） 2019.03.19
 */
public abstract class BaseController<T> {
    // 基础服务
    protected abstract IBaseService getBaseService();

    // 使用InitBinder来处理Date类型的参数
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

    /**
     * 获取框架内当前登录用户名
     *
     * @return
     */
    protected String getLoginUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getPrincipal().toString();
            return currentUserName;
        } else {
            return null;
        }
    }

    /**
     * 获取框架内当前登录用户名的权限
     *
     * @return
     */
    protected Collection<SimpleGrantedAuthority> getAuthorities() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) authentication.getAuthorities();
            return  authorities;
        } else {
            return null;
        }
    }

    /**
     * 导进去Excel。
     * @param file
     * @return
     */

    @PostMapping(value = "import-excel")
    protected  Message importExcel(@RequestParam("file") MultipartFile file){
        Message message = new Message();
        if (file.isEmpty()) {
            message.setMsg("此文件数据为空！");
            message.setCode("400");
            return message;
        }
        String originalFilename = file.getOriginalFilename();
        if (!ExcelUtil.isExcel2003(originalFilename) && !ExcelUtil.isExcel2007(originalFilename)) {
            message.setMsg("文件类型错误，仅支持.xlsx和.xls格式");
            message.setCode("400");
            return message;
        }

        try {
            int result = getBaseService().insertForExcelSheet(originalFilename,file.getInputStream(),"");
        }catch (IOException excpetion){
            excpetion.printStackTrace();
        }finally {
            if(file!=null){
                try{
                    file.getInputStream().close();
                }catch (IOException excpetion){
                    excpetion.printStackTrace();
                }
            }
        }

        return message;
    }

    /**
     * 下载Excel。
     * @param request
     * @param response
     */
    @GetMapping(value = {"download-excel"})
    public void downloadTemplateFile(HttpServletRequest request, HttpServletResponse response) {
        InputStream is = null;
        OutputStream os = null;
        try {
            response.setCharacterEncoding(request.getCharacterEncoding());
            response.setContentType("application/octet-stream");
            ClassPathResource resource = new ClassPathResource("public/excel-template/shift_exchange_import.xls");
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

    /**
     * 新增记录
     * @param record
     * @return
     */
    @PostMapping
    public Message insert(@RequestBody T record, HttpServletRequest request, HttpServletResponse response) {
        Message message = new Message();
        int result = this.getBaseService().insertSelective(record);
        if(result == 0){
            message.setCode("400");
            message.setMsg("新增失败");
        }
        return  message;
    }

    /**
     * 更新记录
     * @param id
     * @param record
     * @return
     */
    @PutMapping(value = {"/{id}"})
    public Message update(@PathVariable("id") String id,@RequestBody T record,HttpServletRequest request,HttpServletResponse response){
        Message message = new Message();
        int result = this.getBaseService().updateByPrimaryKeySelective(record);
        if(result == 0){
            message.setCode("400");
            message.setMsg("修改失败");
        }
        return  message;
    }


    /**
     * @param id
     * @param request
     * @param response
     * @return
     */
    @GetMapping(value = {"/{id}"})
    public Message getById(@PathVariable("id") String id,HttpServletRequest request,HttpServletResponse response){
        Message message = new Message();
        T result = (T) this.getBaseService().selectByPrimaryKey(id);
        if(result == null){
            message.setCode(HttpStatus.NOT_FOUND.value()+"");
            message.setMsg("查询不到");
        }
        message.setData(result);
        return  message;
    }

    /**
     * 删除记录。
     * @param id
     * @return
     */
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
    @GetMapping
    public Message listAll(HttpServletRequest request,HttpServletResponse response) {
        Message message = new Message();
        List list = this.getBaseService().selectByExample(null);
        message.setData(list);
        return  message;
    }

}
