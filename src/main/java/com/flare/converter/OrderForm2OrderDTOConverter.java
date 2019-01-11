package com.flare.converter;

import com.flare.dataobject.OrderDetail;
import com.flare.dataobject.OrderMaster;
import com.flare.dto.OrderDTO;
import com.flare.enums.ResultEnum;
import com.flare.exception.SellException;
import com.flare.form.OrderForm;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName OrderMaster2OrderDTOConverter
 * @Description 转换器
 * @Author EyesSmile
 * @Date 2019/1/5
 * @Version 1.0
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO conver(OrderForm orderForm){
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>(){}.getType());
        } catch (Exception e) {
            log.error("【对象转换】错误，json={}",orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
