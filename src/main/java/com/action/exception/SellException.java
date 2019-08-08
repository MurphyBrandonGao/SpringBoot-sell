package com.action.exception;

import com.action.enums.ResultEnum;

/**
 * @author Dell
 * @create 2019-08-08 15:46
 */
public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super((resultEnum.getMessage()));
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
