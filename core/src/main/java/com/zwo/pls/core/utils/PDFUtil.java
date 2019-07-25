package com.zwo.pls.core.utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.lowagie.text.pdf.BaseFont;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class PDFUtil {

    private PDFUtil() {
    }

    private volatile static Configuration configuration;

    static {
        if (configuration == null) {
            synchronized (PDFUtil.class) {
                if (configuration == null) {
                    configuration = new Configuration(Configuration.VERSION_2_3_28);
                }
            }
        }
    }

    /**
     * freemarker 引擎渲染 html
     *
     * @param dataMap      传入 html 模板的 Map 数据
     * @param 模板文件相对路径(相对于 resources路径,路径 + 文件名)
     *                     eg: "templates/pdf_export_demo.ftl"
     * @return
     */
    public static String freemarkerRender(Map<String, Object> dataMap, String fileName) {
        Writer out = new StringWriter();
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        try {
            File file = new File(fileName);
            configuration.setDirectoryForTemplateLoading(file.getParentFile());
            configuration.setLogTemplateExceptions(false);
            configuration.setWrapUncheckedExceptions(true);
            Template template = configuration.getTemplate(file.getName());
            template.process(dataMap, out);
            out.flush();
            return out.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 使用 iText 生成 PDF 文档
     *
     * @param htmlTmpStr html 模板文件字符串
     * @param fontFile   所需字体文件(相对路径+文件名)
     */
    public static byte[] createPDF(String htmlTmpStr, String fontFile) {
        ByteArrayOutputStream outputStream = null;
        byte[] result = null;
        try {
            outputStream = new ByteArrayOutputStream();
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(htmlTmpStr);
            ITextFontResolver fontResolver = renderer.getFontResolver();
            // 解决中文支持问题,需要所需字体(ttc)文件
            fontResolver.addFont(fontFile, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            renderer.layout();
            renderer.createPDF(outputStream);
            result = outputStream.toByteArray();
            if (outputStream != null) {
                outputStream.flush();
                outputStream.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (com.lowagie.text.DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {

        File file = new File(PDFUtil.class.getClassLoader().getResource(".").getPath() + "ftl//shift_exchange.ftl");
        if (file.exists()) {
            System.out.println(file.getPath());
        }

        String string = PDFUtil.freemarkerRender(null, file.getPath());
        System.out.println(string);

//        byte[] bytes = PDFUtil.createPDF(string,PDFUtil.class.getClassLoader().getResource(".").getPath()+"ftl"+File.separator+"simsunb.ttf");
//        if(bytes != null){
//            FileOutputStream fos = null;
//            try {
//                File file1 = new File("D://myPdf.pdf");
//                if(file1.exists()){
//                    file1.delete();
//                }
//
//                fos = new FileOutputStream("D://myPdf.pdf");
//                fos.write(bytes);
//            }catch (Exception e){
//                e.printStackTrace();
//            }finally {
//                if(fos != null){
//                    try {
//                        fos.close();
//                    }catch (Exception e){
//
//                    }
//                }
//            }
//
//        }
//        System.out.println();

        try {
            LocalDateTime localDate = LocalDateTime.now();
            String name = localDate.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + ".pdf";
            String outPdf = PDFUtil.class.getClassLoader().getResource(".").getPath() + "ftl//" + name;
//            String outPdf = PDFUtil.class.getClassLoader().getResource(".").getPath()+"ftl//myPdf.pdf";
            parseHTML2PDFFile2(outPdf, string);
//            parseHTML2PDFFile2("D://myPdf.pdf", string);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parseHTML2PDFFile2(String pdfFile, String html)
            throws DocumentException, IOException {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document,
                new FileOutputStream(pdfFile));

        InputStream inputStream = null;
        Charset charset = Charset.forName("UTF-8");
        try {
            document.open();
            inputStream = new ByteArrayInputStream(html.getBytes("UTF-8"));
            XMLWorkerHelper.getInstance().parseXHtml(writer, document, inputStream, charset);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (document != null) {
                document.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }
}
