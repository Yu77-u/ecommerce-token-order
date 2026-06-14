package com.shop.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shop.entity.Order;
import java.util.List;

public interface OrderService extends IService<Order> {
    List<Order> getOrderByUserId(Long userId);
    boolean updateOrderStatus(Long orderId, Integer status);
}