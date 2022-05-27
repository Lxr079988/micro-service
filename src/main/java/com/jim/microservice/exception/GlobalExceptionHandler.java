package com.jim.microservice.exception;

import com.jim.microservice.vo.WebResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.TransientDataAccessResourceException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理器
 * @author Jimliu
 * @date 2022/5/26 18:11
 * @copyright 2022 vesync Inc. All rights reserved
 */

@Slf4j
@ResponseBody
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({IllegalArgumentException.class})
    public WebResponse illegalArgumentExceptionHandler(HttpServletRequest req, Exception e) {
        log.error("failed to handler request. uri: {}, Method: {}, headers: {}",
                req.getRequestURI(), req.getMethod(), getHeaders(req), e);
        WebResponse webResponse = WebResponse.globalClientErrorResp(ErrorCode.ILLEGAL_ARGUMENT_ERROR);
        log.error("failed to handler request. response: {}",webResponse);
        return webResponse;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public WebResponse<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest req) {
        log.error("failed to handler request. uri: {}, Method: {}, headers: {}",
                req.getRequestURI(), req.getMethod(), getHeaders(req), e);
        FieldError fieldError = e.getBindingResult().getFieldError();
        return WebResponse.customerError(String.valueOf(System.currentTimeMillis()), ErrorCode.ILLEGAL_ARGUMENT_ERROR, fieldError.getDefaultMessage());
    }

    @ExceptionHandler(BizException.class)
    public WebResponse bizExceptionHandler(HttpServletRequest req, BizException e) {
        log.error("failed to handler request. uri: {}, Method: {}, headers: {}",
                req.getRequestURI(), req.getMethod(), getHeaders(req), e);
        WebResponse webResponse = WebResponse.globalBizErrorResp(e);
        log.error("failed to handler request. response: {}",webResponse);
        return webResponse;
    }

    @ExceptionHandler(Exception.class)
    public WebResponse defaultExceptionHandler(HttpServletRequest req, Exception e) {
        log.error("failed to handler request. uri: {}, Method: {}, headers: {}",
                req.getRequestURI(), req.getMethod(), getHeaders(req), e);
        WebResponse webResponse = WebResponse.globalInternalErrorResp();
        log.error("failed to handler request. response: {}",webResponse);
        return webResponse;
    }


    private Map<String, String> getHeaders(HttpServletRequest request) {
        Map<String, String> headers = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headers.put(headerName, request.getHeader(headerName));
        }
        return headers;
    }

}
