package com.zwo.pls.core.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

/**
 * [描述] Freemarker 工具類
 *
 * @author Yuanquan.Liu
 * @date 2019/7/25
 */
public class FreemarkerUtils {
    @Value("${spring.freemarker.template-loader-path}")
    private static String TEMPLATE_LOADER_PATH;

    private static volatile Configuration configuration;

    static {
        if (configuration == null) {
            configuration = new Configuration(Configuration.VERSION_2_3_28);
        }
    }

    public static Configuration getConfiguration() {
        return configuration;
    }

    public static void setConfiguration(Configuration configuration) {
        FreemarkerUtils.configuration = configuration;
    }

    /**
     * 獲取模板並填充數據
     *
     * @param file      模板文件
     * @param dataModel 數據模型
     * @return HTML
     */
    public static String getFtlContent(File file, Object dataModel) {
        StringWriter stringWriter = new StringWriter();
        try {
            // 模板路徑
            configuration.setDirectoryForTemplateLoading(file.getParentFile());
            // 字符編碼
            configuration.setDefaultEncoding("UTF-8");
            // 定義異常處理，RETHROW_HANDLER是简单重新抛出所有异常而不会做其它的事情。
            configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            // 是否記錄模板處理引發的TemplateExceptions
            configuration.setLogTemplateExceptions(false);
            // 是否將未經檢查的異常包裝到TemplateExceptions
            configuration.setWrapUncheckedExceptions(true);
            // 獲取模板
            Template template = configuration.getTemplate(file.getName());
            // 填充數據
            template.process(dataModel, stringWriter);
            return stringWriter.toString();
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        } finally {
            try {
                stringWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
