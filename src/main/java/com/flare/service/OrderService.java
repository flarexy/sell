package com.flare.service;

import com.flare.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @ClassName OrderService
 * @Description 订单
 * @Author EyesSmile
 * @Date 2018/12/31
 * @Version 1.0
 */
public interface OrderService {

    /** 创建订单 */
    OrderDTO create(OrderDTO orderDTO);
    /** 查询单个订单 */
    OrderDTO findOne(String orderId);
    /** 查询单个订单 */
    OrderDTO findOne(String orderId,String openid);
    /** 查询订单列表 */
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);
    /** 取消订单 */
    OrderDTO cancel(OrderDTO orderDTO);
    /** 完结订单 */
    OrderDTO finish(OrderDTO orderDTO);
    /** 支付订单 */
    OrderDTO paid(OrderDTO orderDTO);
}
