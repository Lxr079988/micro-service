package com.jim.microservice.exception;

/**
 * 错误码枚举类，共五位：错误产生来源+四位数字编号
 * A：错误来源用户
 * B：错误来源当前系统
 * C：错误来源第三方服务
 * @author Jimliu
 * @date 2022/5/26 18:11
 * @copyright 2022 vesync Inc. All rights reserved
 */
public enum ErrorCode {
    SUCCESS("00000", "请求成功"),

    /**
     * A：错误来源用户
     */
    USER_OPERATE_ERROR("A0001", "用户操作错误"),
    ILLEGAL_ARGUMENT_ERROR("A0002", "请求参数错误"),

    /**
     * B：错误来源当前系统
     */
    INTERNAL_ERROR("B0001", "服务器内部错误"),

    /**
     * C：错误来源第三方服务
     */
    CALL_API_ERROR("C0001", "调用第三方接口错误"),
    REPORT_FATAL_ERROR("C0002", "报告生成失败错误"),
    REPORT_CANCELLED_ERROR("C0003", "报告取消失败错误");





    //响应错误码
    private String code;
    //响应内容
    private String msg;

    /**
     * 构造方法
     *
     * @param code
     * @param msg
     */
    ErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ErrorCodeEnum{"
                + "code=" + code
                + ", msg='" + msg + '\''
                + '}';
    }

    public boolean isSuccess() {
        return this.equals(ErrorCode.SUCCESS);
    }
}
