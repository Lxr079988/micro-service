package com.jim.microservice.aspect;

import com.jim.microservice.log.AnalysisLog;
import com.jim.microservice.log.AnalysisLogFmt;
import com.jim.microservice.vo.WebRequest;
import com.jim.microservice.vo.WebResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 日志切面类
 * @author Jimliu
 * @date 2022/5/26 18:11
 * @copyright 2022 vesync Inc. All rights reserved
 */
@Slf4j
@Aspect
@Component
@Order(Integer.MIN_VALUE + 1)
public class LogAspect {

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping) && args(request,..) ")
    public void logPointCut(WebRequest request) {
    }

    @Around(value = "logPointCut(request)")
    public Object doLogging(ProceedingJoinPoint pjp, WebRequest request) throws Throwable {
        String method = pjp.getSignature().getName();
        AnalysisLog<WebRequest, WebResponse> analysisLog = new AnalysisLog<>(request, method);
        AnalysisLogFmt.logRecv(analysisLog);
        WebResponse response = (WebResponse) pjp.proceed();
        analysisLog.setResponse(response);
        AnalysisLogFmt.logSend(analysisLog);
        return response;
    }
}
