package com.flare.controller;

import com.flare.VO.ProductInfoVO;
import com.flare.VO.ProductVO;
import com.flare.VO.ResultVO;
import com.flare.dataobject.ProductCategory;
import com.flare.dataobject.ProductInfo;
import com.flare.service.CategoryService;
import com.flare.service.ProductService;
import com.flare.util.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName BuyerProductController
 * @Description 买家商品
 * @Author EyesSmile
 * @Date 2018/12/30
 * @Version 1.0
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list(){
        // 1.查询所有上架商品
        List<ProductInfo> productInfoList= productService.findUpAll();

        // 2.查询类目（一次性查询）
//        List<Integer> categoryTypeList = new ArrayList<>();
        // 传统方法
//        for(ProductInfo productInfo: productInfoList) {
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        // 精简方法(jave8.lombda)
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        // 3.数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo: productInfoList){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }

}
