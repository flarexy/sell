package com.flare.converter;

import com.flare.dataobject.OrderMaster;
import com.flare.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName OrderMaster2OrderDTOConverter
 * @Description 转换器
 * @Author EyesSmile
 * @Date 2019/1/5
 * @Version 1.0
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO conver(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }
    public static List<OrderDTO> conver(List<OrderMaster> orderMasterList){
        return orderMasterList
                .stream()
                .map(e->conver(e))
                .collect(Collectors.toList());
    }
}
