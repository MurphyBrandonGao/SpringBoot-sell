package com.action.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Dell
 * @create 2019-08-07 21:42
 */
@Data
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = -8180236900783103375L;
    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;
}
