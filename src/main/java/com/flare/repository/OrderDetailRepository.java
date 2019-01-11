package com.flare.repository;

import com.flare.dataobject.OrderDetail;
import com.flare.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassName OrderMasterRepository
 * @Description 订单详情
 * @Author EyesSmile
 * @Date 2018/12/31
 * @Version 1.0
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {

    List<OrderDetail> findByOrderId(String orderId);
}
