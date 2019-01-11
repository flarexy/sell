package com.flare.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.flare.dataobject.OrderDetail;
import com.flare.enums.OrderStatusEnum;
import com.flare.enums.PayStatusEnum;
import com.flare.util.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @ClassName OrderDTO
 * @Description 订单DTO
 * @Author EyesSmile
 * @Date 2018/12/31
 * @Version 1.0
 */
@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

    /**
     * 订单ID
     */
    private String OrderId;
    /**
     * 买家名字
     */
    private String buyerName;
    /**
     * 买家手机号
     */
    private String buyerPhone;
    /**
     * 买家地址
     */
    private String buyerAddress;
    /**
     * 买家Openid
     */
    private String buyerOpenid;
    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;
    /**
     * 订单状态,默认为0新订单
     */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
    /**
     * 支付状态，默认为0未支付
     */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();
    /**
     * 创建时间
     */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;
    /**
     * 更新时间
     */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;
    /**
     * 详情列表
     */
    private List<OrderDetail> orderDetailList;
}
