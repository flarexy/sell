package com.flare.dto;

import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * @ClassName CartDTO
 * @Description 购物车
 * @Author EyesSmile
 * @Date 2018/12/31
 * @Version 1.0
 */
@Data
public class CartDTO {
    /** 商品ID */
    private String productId;

    /** 购买数量 */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
