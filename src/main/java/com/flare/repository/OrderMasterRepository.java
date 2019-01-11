package com.flare.repository;

import com.flare.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName OrderMasterRepository
 * @Description 订单
 * @Author EyesSmile
 * @Date 2018/12/31
 * @Version 1.0
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {

    Page<OrderMaster> findByBuyerOpenid(String buyOpenid, Pageable pageable);
}
