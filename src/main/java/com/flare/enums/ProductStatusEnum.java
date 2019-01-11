package com.flare.enums;

import lombok.Getter;

/**
 * @ClassName ProductStatusEnum
 * @Description TODO
 * @Author EyesSmile
 * @Date 2018/12/30
 * @Version 1.0
 */
@Getter
public enum ProductStatusEnum {

    UP(0,"在架"),
    DOWN(1,"下架")
    ;
    private Integer code;
    private String message;

    ProductStatusEnum(Integer code,String message) {
        this.code = code;
        this.message = message;
    }
}
