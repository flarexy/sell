package com.flare.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @ClassName ProductVO
 * @Description 商品（包含类目）
 * @Author EyesSmile
 * @Date 2018/12/30
 * @Version 1.0
 */
@Data
public class ProductVO {

    /**
     *  JsonProperty序列号返回给前端名称
     */
    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;

}
