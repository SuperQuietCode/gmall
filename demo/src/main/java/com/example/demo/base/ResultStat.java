package com.example.demo.base;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * 返回状态码
 *
 * @author ZhaoXin
 * @date 2020/9/25 13:53
 */
public enum ResultStat {
    // 正确状态码
    SUCCESS(0, "success"),

    // 异常错误状态码,
    ERROR(999, "error"),
    EXCEPTION(-1, "处理异常"),
    RUNTIME_EXCEPTION(-2, "处理异常"),
    IO_EXCEPTION(-3, "处理异常"),
    FILE_NOT_FOUND_EXCEPTION(-4, "处理异常"),
    INVITE_ORG_INFO_EXCEPTION(-5, "处理异常"),
    // 公共错误状态码
    PAYLOAD_MISS(1, "参数错误"),

    // http状态码
    OK(200, "ok"),
    BAD_REQUEST(400, "bad request"),
    FORBIDDEN(403, "forbidden"),
    NOT_FOUND(404, "not found"),
    REQUEST_TIMEOUT(408, "request  "),
    INTERNAL_SERVER_ERROR(500, "internal server error"),

    // 010**，用户登录状态码
    CODE_LOSE(1004, "验证码失效"),
    CODE_ERR(1005, "验证码输入错误"),

    UNKNOWN(99999, "unknown");

    private final int code;
    private final String message;

    ResultStat(int code) {
        this.code = code;
        this.message = null;
    }

    ResultStat(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Contract(pure = true)
    public int getCode() {
        return code;
    }

    @Contract(pure = true)
    public String getMessage() {
        return message;
    }

    @NotNull
    @Contract(pure = true)
    public DataResult wrap(Object data) {
        return wrap(data, this.message);
    }

    /**
     * 封装响应结果
     *
     * @param data    响应数据
     * @param message 响应message
     * @return 响应内容
     */
    @NotNull
    @Contract(value = "_, _ -> new", pure = true)
    public DataResult wrap(Object data, String message) {
        return new DataResult(data, this, message);
    }

    @NotNull
    @Contract(pure = true)
    public BaseResult wrapBase() {
        return wrapBase(this.message);
    }

    @NotNull
    @Contract(value = "_ -> new", pure = true)
    public BaseResult wrapBase(String message) {
        return new BaseResult(this, message);
    }

}
