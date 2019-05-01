package com.zwo.pls.core.converter;


import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

/**
 * YearMonth 自定义年月参数绑定转换器
 *
 * @author Yuanquan.Liu
 * @date 2019-03
 */
public class CustomYearMonthConverter implements Converter<String, YearMonth> {
    @Override
    public YearMonth convert(String s) {
        if (StringUtils.isEmpty(s)) {
            return null;
        }
        return YearMonth.parse(s, DateTimeFormatter.ofPattern("yyyy-MM"));
    }
}
