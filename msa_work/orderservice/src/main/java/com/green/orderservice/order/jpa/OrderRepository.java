package com.green.orderservice.order.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderEntity,Long> {

    // select * from users where order =?;
    Optional<OrderEntity> findByUserId(String userId);

}
