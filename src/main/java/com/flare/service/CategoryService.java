package com.flare.service;

import com.flare.dataobject.ProductCategory;

import java.util.List;

/**
 * @ClassName CategoryService
 * @Description 类目
 * @Author EyesSmile
 * @Date 2018/12/30
 * @Version 1.0
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
