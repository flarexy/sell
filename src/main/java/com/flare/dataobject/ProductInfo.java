package com.flare.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @ClassName ProductInfoRepository
 * @Description 商品信息
 * @Author EyesSmile
 * @Date 2018/12/30
 * @Version 1.0
 */
@Entity
@Data
public class ProductInfo {
    @Id
    private String productId;
    /**
     * 名字
     */
    private String productName;
    /**
     * 单价
     */
    private BigDecimal productPrice;
    /**
     * 库存
     */
    private Integer productStock;
    /**
     * 描述
     */
    private String productDescription;
    /**
     * 小图
     */
    private String productIcon;
    /**
     * 状态 0正常 1下架
     */
    private Integer productStatus;
    /**
     * 类目编号
     */
    private Integer categoryType;
}
