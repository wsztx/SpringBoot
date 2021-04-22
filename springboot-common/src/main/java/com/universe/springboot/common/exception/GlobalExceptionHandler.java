package com.universe.springboot.common.exception;

import com.universe.springboot.common.enums.ResultCodeEnum;
import com.universe.springboot.common.util.LocaleMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    final static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private LocaleMessage localeMessage;

    /**
     * 异常处理,返回json格式
     * @param exception
     * @param request
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = {BusinessException.class})
    @Order(value = 1)
    public Response handlerException(BusinessException exception, HttpServletRequest request){
        String message = localeMessage.getMessage(exception.getCode());
        log.error("BusinessException error occurred, code:{}, message:{}", exception.getCode(), message);
        return new Response(Boolean.FALSE, exception.getCode(), message);
    }

    /**
     * 异常处理,指向错误页面
     * @param throwable
     * @param request
     * @return
     */
    @ExceptionHandler(value = {Throwable.class})
    @Order(value = 99)
    public String throwableHandler(Throwable throwable, HttpServletRequest request){
        log.error("Throwable occurred.", throwable);
//        Map<String, Object> ext = new HashMap<>();
//        ext.put("code", ResultCodeEnum.FAIL.getCode());
//        ext.put("message", localeMessage.getMessage(ResultCodeEnum.FAIL.getCode()));
//        ext.put("success", Boolean.FALSE);
//        ext.put("timestamp", dtf.format(LocalDateTime.now()));
//        ext.put("data", null);
//        request.setAttribute("ext", ext);
//        request.setAttribute(RequestDispatcher.ERROR_STATUS_CODE, HttpStatus.INTERNAL_SERVER_ERROR.value());
        return "forward:/error";
    }
}
