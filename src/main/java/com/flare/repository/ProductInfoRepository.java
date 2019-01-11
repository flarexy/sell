package com.flare.repository;

import com.flare.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassName ProductInfoRepository
 * @Description 商品信息
 * @Author EyesSmile
 * @Date 2018/12/30
 * @Version 1.0
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);


}
