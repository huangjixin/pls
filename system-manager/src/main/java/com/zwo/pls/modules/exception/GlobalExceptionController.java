package com.zwo.pls.modules.exception;

import com.zwo.pls.core.vo.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ValidationException;
import java.time.format.DateTimeParseException;

/**
 * 全局异常统一处理
 *
 * @author Yuanquan.Liu
 * @date 2018/10/18
 */
@ControllerAdvice
public class GlobalExceptionController {
    private static Logger log = LoggerFactory.getLogger("GLOBAL_EXCEPTION_HANDLE");

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Message errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
        Message message = new Message();

        try {
            log.info("全局统一异常处理：START...");
            log.warn(e.getLocalizedMessage());
            // 日期转换
            /*if (e instanceof DateTimeParseException) {
                return ResultMessage.build(400, "错误：" + e.getMessage() + "，文本日期的格式须为：yyyy-MM-dd，年月份格式须为：yyyy-MM");
            }*/
            if (e instanceof NumberFormatException) {
                message.setMsg("存在非法数字");
                message.setCode(400);
                return message;
            }
            // ValidationException
            if (e instanceof ValidationException) {
                message.setCode(400);
                message.setMsg(e.getMessage());
                return message;
            }
            // spring security Exception
            if (e instanceof AccessDeniedException) {
                message.setCode(403);
                message.setMsg("请求失败，您尚无权限访问");
                return message;
            }
            // shiro exception
            /*if (e instanceof UnauthorizedException) {
                return ResultMessage.build(403, "请求失败，您尚无权限访问");
            }
            if (e instanceof UnknownAccountException) {
                return ResultMessage.build(400, "用户名错误");
            }
            if (e instanceof IncorrectCredentialsException) {
                return ResultMessage.build(400, "密码错误");
            }*/
            if (e instanceof MissingServletRequestParameterException) {
                String parameterName = ((MissingServletRequestParameterException) e).getParameterName();
                message.setCode(400);
                message.setMsg("缺少请求参数：" + parameterName);
                return message;
            }
            if (e instanceof HttpRequestMethodNotSupportedException) {
                String method = ((HttpRequestMethodNotSupportedException) e).getMethod();
                message.setCode(400);
                message.setMsg("不支持的HTTP 请求方法：" + method);
                return message;
            }
            e.printStackTrace();
            message.setCode(500);
            message.setMsg(e.getMessage());
            return message;
        } finally {
            log.info("全局统一异常处理：END...");
        }
    }
}
