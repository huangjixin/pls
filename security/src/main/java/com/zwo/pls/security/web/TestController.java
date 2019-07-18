package com.zwo.pls.security.web;

import com.itextpdf.text.DocumentException;
import com.zwo.pls.core.utils.PDFUtil;
import com.zwo.pls.security.service.IUserService;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 一句话描述该类功能：
 * Created by Tony(黄记新) in 2019/4/30
 */
@RestController
@RequestMapping("test")
public class TestController {
//    private static Logger logger = LogManager.getLogger(TestController.class);

    @Autowired
    private IUserService userService;

    @GetMapping("setsession")
    public String setsession(HttpSession httpSession){
        httpSession.setAttribute("username","huangjixin");
        return  "设置session成功，username:huangjixin";
    }

    @GetMapping("getsession")
    public String getsession(HttpSession httpSession){
        String username = (String) httpSession.getAttribute("username");
        return  username;
    }

    @GetMapping("clearsession")
    public String clearsession(HttpSession httpSession){
        httpSession.removeAttribute("username");
        return  "移除session成功";
    }

    @GetMapping("hello")
    public String hello(HttpSession httpSession){
//        logger.log("测试打印");
        return  "hello,huang";
    }

    @GetMapping("throwexception")
    public String throwexception(HttpSession httpSession) throws Exception{
        if( 1==1){
            throw new Exception("报错了");
        }
        return  "hello,huang";
    }

    /**
     * PDF 文件导出
     * 使用 a 链接即可下载;如果为 ajax/vue,则需要转换为 form 表单格式
     * eg: http://${apiAddress}/api/demo/common/export?key1=${key}&key2=${key2}
     */
    @RequestMapping(value = "/export", method = {RequestMethod.POST, RequestMethod.GET},
            produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> export(){
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity responseEntity = null;
        URL url =  PDFUtil.class.getClassLoader().getResource("ftl//shift_exchange.ftl");
        File file = new File(url.getPath());
        if(null != url){
            System.out.println(file.getPath());
        }

        String string = PDFUtil.freemarkerRender(null,file.getPath());

        LocalDateTime localDate = LocalDateTime.now();
        String name = localDate.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + ".pdf";
        String outPdf = PDFUtil.class.getClassLoader().getResource(".").getPath() + "ftl//" + name;
        FileInputStream fis= null;
        File file1 = null;
        try {
            PDFUtil.parseHTML2PDFFile2(outPdf, string);
            file1 =  new File(PDFUtil.class.getClassLoader().getResource(".").getPath() + "ftl//" + name);
            if(file1.exists()){
                fis=new FileInputStream (file1);
                if(fis!=null) {
                    int len = fis.available();
                    byte[] bytes = new byte[len];
                    fis.read(bytes);
                    headers.setContentDispositionFormData("attachment", name);
                    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                    return new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(fis != null ){
                try {
                    fis.close();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if( file1 !=  null ){
                if( file1.exists()){
                    file1.delete();
                    file1 = null;
                }
            }
        }

        return responseEntity;
    }

    @ApiOperation(value = "交班管理PDF導出", notes = "交班管理PDF導出")
    @RequestMapping(value = "/excel-export", method = {RequestMethod.POST, RequestMethod.GET},
            produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void exportFormDataPDF(HttpServletRequest request, HttpServletResponse response) {

        String shift_exchangeFtlName = PDFUtil.class.getClassLoader().getResource(".").getPath() + "ftl//shift_exchange.ftl";
        File file = new File(shift_exchangeFtlName);

        List list = null;
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("exchangeList", list);
        dataMap.put("exshiftDate", request.getParameter("startDate"));
        String deptName = request.getParameter("deptName");
        if (null == deptName) {
            deptName = "";
        }
        dataMap.put("deptName", deptName);
        String string = PDFUtil.freemarkerRender(dataMap, file.getPath());

        LocalDateTime localDate = LocalDateTime.now();
        String name = localDate.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + ".pdf";
        String outPdf = PDFUtil.class.getClassLoader().getResource(".").getPath() + "ftl//" + name;

        InputStream is = null;
        OutputStream os = null;
        File file1 = null;
        try {
            PDFUtil.parseHTML2PDFFile2(outPdf, string);

            response.setCharacterEncoding(request.getCharacterEncoding());
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename=" + name);

            String filePath = PDFUtil.class.getClassLoader().getResource(".").getPath() + "ftl//" + name;

            file1 = new File(PDFUtil.class.getClassLoader().getResource(".").getPath() + "ftl//" + name);
            is = new FileSystemResource(file1.getAbsolutePath()).getInputStream();
            os = response.getOutputStream();
            IOUtils.copy(is, os);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(is);
            IOUtils.closeQuietly(os);

            if (file1 != null) {
                if (file1.exists()) {
                    file1.delete();
                    file1 = null;
                }
            }
        }
    }

}
