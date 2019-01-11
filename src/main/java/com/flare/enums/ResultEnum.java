package com.flare.enums;

import lombok.Getter;

/**
 * @ClassName ResultEnum
 * @Description 前端提示消息
 * @Author EyesSmile
 * @Date 2018/12/31
 * @Version 1.0
 */
@Getter
public enum ResultEnum {

    PARAM_ERROR(1,"参数错误"),

    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"商品库存错误"),
    ORDER_NOT_EXIST(12,"订单不存在"),
    ORDER_DETAIL_NOT_EXIST(13,"订单详情不存在"),
    ORDER_STATUS_ERROR(14,"订单状态错误"),
    ORDER_UPDATE_FAIL(15,"订单更新失败"),
    ORDER_DETAIL_EMPTY(16,"订单详情为空"),
    ORDER_PAY_STATUS_ERROR(17,"订单支付状态错误"),
    CART_EMPTY(18,"购物车不能为空"),
    ORDER_OWNER_ERROR(19,"该订单不属于当前用户"),
    WECHAT_MP_ERROR(20,"微信公众账号错误"),

    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
