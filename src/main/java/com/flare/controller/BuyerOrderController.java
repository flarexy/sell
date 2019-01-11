package com.flare.controller;

import com.flare.VO.ResultVO;
import com.flare.converter.OrderForm2OrderDTOConverter;
import com.flare.dto.OrderDTO;
import com.flare.enums.ResultEnum;
import com.flare.exception.SellException;
import com.flare.form.OrderForm;
import com.flare.service.BuyerService;
import com.flare.service.OrderService;
import com.flare.util.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BuyerOrderController
 * @Description 订单操作
 * @Author EyesSmile
 * @Date 2019/1/5
 * @Version 1.0
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private BuyerService buyerService;

    /**
     * 创建订单
     * @param orderForm
     * @param bindingResult
     * @return
     */
    @PostMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确，orderForm={}",orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.conver(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO result = orderService.create(orderDTO);
        Map<String,String> map = new HashMap<>(16);
        map.put("orderId",result.getOrderId());

        return ResultVOUtil.success(map);
    }

    /**
     * 获取列表
     * @param openid
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page",defaultValue = "0") Integer page,
                                         @RequestParam(value = "size",defaultValue = "10") Integer size){
        if (StringUtils.isEmpty(openid)) {
            log.error("【查询订单列表】openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest request = new PageRequest(page,size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid,request);
        return ResultVOUtil.success(orderDTOPage.getContent());
    }

    /**
     * 获取详情
     * @param openid
     * @param orderId
     * @return
     */
    @GetMapping("/detail")
    public ResultVO<List<OrderDTO>> detail(@RequestParam("openid") String openid,
                                            @RequestParam("orderId") String orderId){
        OrderDTO orderDTO = buyerService.findOrderOne(openid,orderId);
        return ResultVOUtil.success(orderDTO);
    }

    /**
     * 取消订单
     * @param openid
     * @param orderId
     * @return
     */
    @PostMapping("/cancel")
    public ResultVO<List<OrderDTO>> cancel(@RequestParam("openid") String openid,
                                            @RequestParam("orderId") String orderId){
        buyerService.cancelOrder(openid,orderId);
        return ResultVOUtil.success();
    }

}
