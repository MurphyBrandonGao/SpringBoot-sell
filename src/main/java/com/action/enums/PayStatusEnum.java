package com.action.enums;

import lombok.Getter;

/**支付状态
 * @author Dell
 * @create 2019-08-08 13:32
 */
@Getter
public enum PayStatusEnum implements CodeEnum {

    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),;

    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
