package com.zwo.pls.security.web;

import io.swagger.annotations.ApiOperation;
import org.apache.poi.util.IOUtils;
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
 * Created by Tony(黄记新) in 2019/7/12
 */
@RestController
@RequestMapping("pdf")
public class PDFController {

    @GetMapping
    public void generatePDF(){

    }

    @ApiOperation(value = "测试模板下载", notes = "测试模板下载")
    @GetMapping(value = {"/download-template"})
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
            IOUtils.closeQuietly(is);
            IOUtils.closeQuietly(os);
        }
    }
}
