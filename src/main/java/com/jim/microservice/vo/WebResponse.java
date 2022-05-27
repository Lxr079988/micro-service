package com.jim.microservice.vo;

import com.jim.microservice.exception.BizException;
import com.jim.microservice.exception.ErrorCode;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 服务响应类
 * @author Jimliu
 * @date 2022/5/26 18:11
 * @copyright 2022 vesync Inc. All rights reserved
 */
@Data
public class WebResponse<T> {

    @NotBlank(message = "traceId should not be null or be empty")
    private String traceId;

    @NotNull(message = "code should not be null")
    private String code;

    @NotNull(message = "msg should not be null")
    private String msg;

    private T result;

    public WebResponse(){}

    private WebResponse(String traceId, ErrorCode errorCode) {
        this(traceId, errorCode, null);
    }


    private WebResponse(String traceId, ErrorCode errorCode, T result) {
        this.traceId = traceId;
        this.result = result;
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }


    public static WebResponse successRespFromReq(WebRequest webRequest) {
        return fromReq(webRequest, ErrorCode.SUCCESS);
    }

    public static <T> WebResponse<T> successRespFromReq(WebRequest webRequest, T result) {
        return fromReq(webRequest, ErrorCode.SUCCESS, result);
    }

    public static WebResponse globalBizErrorResp(BizException e) {
        WebResponse  webResponse= new WebResponse(String.valueOf(System.currentTimeMillis()), e.getErrorCode());
        webResponse.setMsg(e.getMessage());
        return webResponse;
    }

    public static WebResponse globalClientErrorResp(ErrorCode errorCode) {
        return new WebResponse(String.valueOf(System.currentTimeMillis()), errorCode);
    }

    public static WebResponse globalInternalErrorResp() {
        return new WebResponse(String.valueOf(System.currentTimeMillis()), ErrorCode.INTERNAL_ERROR);
    }

    public static <T> WebResponse<T> fromReq(WebRequest webRequest, ErrorCode errorCode) {
        return fromReq(webRequest, errorCode, null);
    }

    public static <T> WebResponse<T> fromReq(@NotNull WebRequest webRequest, @NotNull ErrorCode errorCode, T result) {
        return new WebResponse<T>(webRequest.getTraceId(), errorCode, result);
    }

    /**
     * @param traceId 请求id
     * @param errorCode 错误码对象
     * @param errMsg 错误消息
     * @param <T> 返回体
     * @return
     */
    public static <T> WebResponse<T> customerError(String  traceId,ErrorCode errorCode,String errMsg ) {
        WebResponse webResponse = new WebResponse(traceId,errorCode);
        webResponse.setMsg(errMsg);
        return webResponse;
    }

    @Override
    public String toString() {
        return "WebResponse{" + "traceId='" + traceId + '\'' + ", code=" + code + ", msg='" + msg + '\'' + ", result="
                + result + '}';
    }

}
