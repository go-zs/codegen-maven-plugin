package io.github.gogozs.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RspCode implements IStatus {
    SUCCESS(0, "成功"),
    ERROR(500, "系统忙，请稍后重试"),
    FAIL(-1, "操作失败"),
    NOT_LOGIN(20001, "用户未登录"),
    INVALID_ARGUMENTS(20000, "参数错误"),
    USER_IDENTITY_FAIL(20002, "用户校验失败");

    private final Integer code;
    private final String msg;

    public boolean isEquals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof Integer) {
            return this.getCode().equals((Integer) obj);
        } else if (obj instanceof RspCode) {
            return this.getCode().equals(((RspCode) obj).getCode());
        }
        return false;
    }
}
