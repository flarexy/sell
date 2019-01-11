package com.flare.exception;

import com.flare.enums.ResultEnum;

/**
 * @ClassName SellException
 * @Description 异常
 * @Author EyesSmile
 * @Date 2018/12/31
 * @Version 1.0
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String defaultMessage) {
        super(defaultMessage);
        this.code = code;
    }
}
