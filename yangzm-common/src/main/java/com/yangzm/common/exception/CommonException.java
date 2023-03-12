package com.yangzm.common.exception;


import com.yangzm.common.api.ResultCode;

/**
 * @author yangzhengming
 * @description 〈〉
 * @create 2023/2/24 12:56
 * @since 1.0.0
 */
public class CommonException extends RuntimeException {
    private ResultCode resultCode;

    public CommonException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }

    public CommonException(String message) {
        super(message);
    }

    public CommonException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommonException(Throwable cause) {
        super(cause);
    }

    public CommonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ResultCode getResultCode() {
        return resultCode;
    }
}
