package com.zwo.pls.core.web;

import org.apache.poi.util.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * [描述] 模板下载
 *
 * @author Yuanquan.Liu
 * @date 2019/8/9
 */
//@RestController
//@RequestMapping("/download")
public abstract class DownloadController extends BaseController {
    @GetMapping(value = {"/excel/{fileName}"})
    public void downloadTemplate(@PathVariable(name = "fileName") String fileName, HttpServletRequest request, HttpServletResponse response) {
        String templatePath = "public/excel-template";
        String path = templatePath + "/" + fileName;
        InputStream is = null;
        OutputStream os = null;
        try {
            response.setCharacterEncoding(request.getCharacterEncoding());
            response.setContentType("application/octet-stream");
            ClassPathResource resource = new ClassPathResource(path);
            response.setHeader("Content-Disposition", "attachment; filename=" + resource.getFilename());
            is = resource.getInputStream();
            os = response.getOutputStream();
            IOUtils.copy(is, os);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(is);
            IOUtils.closeQuietly(os);
        }
    }
}
