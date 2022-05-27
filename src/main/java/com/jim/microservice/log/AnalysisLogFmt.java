package com.jim.microservice.log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;

/**
 * 分析日志格式化工具
 * @author Jimliu
 * @date 2022/5/26 18:11
 * @copyright 2022 vesync Inc. All rights reserved
 */
@Slf4j
public class AnalysisLogFmt {

    private static final Logger ANALYSIS_LOGGER = LoggerFactory
            .getLogger("com.etekcity.productmanagement.log.AnalysisLog");
    private static final String ANALYSIS_SEND = "Analysis.send";
    private static final String ANALYSIS_RECV = "Analysis.recv";
    public static Gson gson = new GsonBuilder().serializeNulls().disableHtmlEscaping()
            .setDateFormat("yyyy-MM-dd HH:mm:ss.SSS").create();

    public static void logRecv(AnalysisLog analysisLog) {
        logRecv(ANALYSIS_LOGGER, Level.INFO, analysisLog);
    }

    public static void logRecv(Logger logger, Level level, AnalysisLog analysisLog) {
        String logPayload = gson.toJson(analysisLog);
        log(logger, level, String.format("%s: %s", ANALYSIS_RECV, logPayload));
    }

    public static void logSend(AnalysisLog analysisLog) {
        logSend(ANALYSIS_LOGGER, Level.INFO, analysisLog);
    }

    public static void logSend(Logger logger, Level level, AnalysisLog analysisLog) {
        String logPayload = gson.toJson(analysisLog);
        log(logger, level, String.format("%s: %s", ANALYSIS_SEND, logPayload));
    }

    private static void log(Logger logger, Level level, String s) {
        switch (level) {
            case ERROR:
                logger.error(s);
                break;
            case WARN:
                logger.warn(s);
                break;
            case INFO:
            case TRACE:
                logger.info(s);
                break;
            case DEBUG:
                logger.debug(s);
                break;
            default:
                throw new RuntimeException(String.format("unknown log level: %s", level));
        }
    }
}
