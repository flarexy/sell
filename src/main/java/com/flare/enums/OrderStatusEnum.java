package com.flare.enums;

import lombok.Getter;

/**
 * @ClassName OrderStatusEnum
 * @Description 订单状态
 * @Author EyesSmile
 * @Date 2018/12/31
 * @Version 1.0
 */
@Getter
public enum OrderStatusEnum {
    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"已取消")
    ;
    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
