package com.flare.repository;

import com.flare.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){

        ProductCategory productCategory = repository.findOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
    @Transactional
    public void saveTest(){
//        ProductCategory productCategory = new ProductCategory();
//        productCategory.setCategoryId(2);
//        productCategory.setCategoryName("女生最爱2");
//        productCategory.setCategoryType(3);
//        repository.save(productCategory);
//
//        ProductCategory productCategory1 = repository.findOne(2);
//        System.out.println(productCategory1.toString());
        List<Integer> list = Arrays.asList(1,2);
        List<ProductCategory> results = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,results.size());
    }
}