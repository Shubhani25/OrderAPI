package com.tgt.upcurve.OrderAPI.repository;

import com.tgt.upcurve.OrderAPI.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
