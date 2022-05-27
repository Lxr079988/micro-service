package com.jim.microservice.vo;

import com.jim.microservice.exception.ErrorCode;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * 服务请求类
 * @author Jimliu
 * @date 2022/5/26 18:11
 * @copyright 2022 vesync Inc. All rights reserved
 */
@Data
public class WebRequest<T> {

    @NotBlank(message = "traceId should not be null or be empty")
    private String traceId;

    @NotBlank(message = "accountID should not be null or be empty")
    private String accountID;

    private String appKey;

    private String token;

    @Valid
    private T data;

    public WebRequest() {
    }

    public WebRequest(@NotBlank String traceId, @NotBlank String accountID, String token, @Valid T data) {
        this.traceId = traceId;
        this.accountID = accountID;
        this.token = token;
        this.data = data;
    }

    public <T> WebResponse<T> genSuccessResp() {
        return WebResponse.successRespFromReq(this);
    }

    public <T> WebResponse<T> genSuccessResp(T result) {
        return WebResponse.successRespFromReq(this, result);
    }

    public <T> WebResponse<T> genResp(ErrorCode errorCode, T result) {
        return WebResponse.fromReq(this, errorCode, result);
    }

}
