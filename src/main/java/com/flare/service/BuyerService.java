package com.flare.service;

import com.flare.dto.OrderDTO;

/**
 * @ClassName BuyerService
 * @Description 买家
 * @Author EyesSmile
 * @Date 2019/1/5
 * @Version 1.0
 */
public interface BuyerService {

    /**
     * 查询一个订单
     * @param openid
     * @param orderId
     * @return
     */
    OrderDTO findOrderOne(String openid,String orderId);

    /**
     * 取消订单
     * @param openid
     * @param orderId
     * @return
     */
    OrderDTO cancelOrder(String openid,String orderId);
}
