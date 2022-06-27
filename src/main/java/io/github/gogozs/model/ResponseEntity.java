package io.github.gogozs.model;

import io.github.gogozs.common.IStatus;
import io.github.gogozs.common.RspCode;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ResponseEntity<T> {
    private static final long serialVersionUID = -8410442306784438229L;

    int code;
    String message;
    T data;

    ResponseEntity() {
    }

    ResponseEntity(IStatus status) {
        this.code = status.getCode();
        this.message = status.getMsg();
    }

    ResponseEntity(RspCode code, T data) {
        this.code = code.getCode();
        this.message = code.getMsg();
        this.data = data;
    }

    ResponseEntity(int code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public static <T> ResponseEntity<T> success() {
        return new ResponseEntity<>(RspCode.SUCCESS);
    }

    public static <T> ResponseEntity<T> success(T data) {

        return new ResponseEntity<>(RspCode.SUCCESS, data);
    }

    public static <T> ResponseEntity<T> fail() {
        return new ResponseEntity<>(RspCode.FAIL);
    }

    public static <T> ResponseEntity<T> fail(T exception) {
        return new ResponseEntity<>(RspCode.FAIL, exception);
    }


    public static <T> ResponseEntity<T> invalid() {
        return new ResponseEntity<>(RspCode.INVALID_ARGUMENTS);
    }

    public static <T> ResponseEntity<T> response(IStatus status, T data) {
        ResponseEntity<T> r = new ResponseEntity<>(status);
        r.setData(data);
        return r;
    }

    public static <T> ResponseEntity<T> response(RspCode code) {
        return new ResponseEntity<>(code);
    }
}
