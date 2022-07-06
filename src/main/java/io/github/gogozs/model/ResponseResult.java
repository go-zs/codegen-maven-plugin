package io.github.gogozs.model;

import io.github.gogozs.common.IStatus;
import io.github.gogozs.common.RspCode;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ResponseResult<T> {
    private static final long serialVersionUID = -8410442306784438229L;

    int code;
    String message;
    T data;

    ResponseResult() {
    }

    ResponseResult(IStatus status) {
        this.code = status.getCode();
        this.message = status.getMsg();
    }

    ResponseResult(RspCode code, T data) {
        this.code = code.getCode();
        this.message = code.getMsg();
        this.data = data;
    }

    ResponseResult(int code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public static <T> ResponseResult<T> success() {
        return new ResponseResult<>(RspCode.SUCCESS);
    }

    public static <T> ResponseResult<T> success(T data) {

        return new ResponseResult<>(RspCode.SUCCESS, data);
    }

    public static <T> ResponseResult<T> fail() {
        return new ResponseResult<>(RspCode.FAIL);
    }

    public static <T> ResponseResult<T> fail(T exception) {
        return new ResponseResult<>(RspCode.FAIL, exception);
    }


    public static <T> ResponseResult<T> invalid() {
        return new ResponseResult<>(RspCode.INVALID_ARGUMENTS);
    }

    public static <T> ResponseResult<T> response(IStatus status, T data) {
        ResponseResult<T> r = new ResponseResult<>(status);
        r.setData(data);
        return r;
    }

    public static <T> ResponseResult<T> response(RspCode code) {
        return new ResponseResult<>(code);
    }
}
