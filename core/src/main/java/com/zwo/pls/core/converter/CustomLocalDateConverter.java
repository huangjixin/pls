package com.zwo.pls.core.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * LocalDate 自定义日期参数绑定转换器
 *
 * @author Yuanquan.Liu
 * @date 2019-03
 */
public class CustomLocalDateConverter implements Converter<String, LocalDate> {
    @Override
    public LocalDate convert(String s) {
        if (StringUtils.isEmpty(s)) {
            return null;
        }
        return LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
