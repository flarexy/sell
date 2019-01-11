package com.flare.repository;

import com.flare.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassName ProductCategoryRepository
 * @Description 类目DAO
 * @Author EyesSmile
 * @Date 2018/12/29
 * @Version 1.0
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
