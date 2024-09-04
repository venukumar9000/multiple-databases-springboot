package com.example.mds.orderRepository;

import com.example.mds.orderentity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderDao extends CrudRepository<Order,Integer> {
}
