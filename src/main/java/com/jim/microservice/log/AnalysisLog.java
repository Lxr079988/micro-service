package com.jim.microservice.log;

import java.util.Date;

/**
 * 分析日志类
 * @author Jimliu
 * @date 2022/5/26 18:11
 * @copyright 2022 vesync Inc. All rights reserved
 */
public class AnalysisLog<REQ, RESP> {

    private Date requestTime;

    private REQ request;

    private String reqMethod;

    private RESP response;

    public AnalysisLog(REQ request, String reqMethod) {
        this.requestTime = new Date();
        this.reqMethod = reqMethod;
        this.request = request;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public REQ getRequest() {
        return request;
    }

    public void setRequest(REQ request) {
        this.request = request;
    }

    public String getReqMethod() {
        return reqMethod;
    }

    public void setReqMethod(String reqMethod) {
        this.reqMethod = reqMethod;
    }

    public RESP getResponse() {
        return response;
    }

    public void setResponse(RESP response) {
        this.response = response;
    }
}
