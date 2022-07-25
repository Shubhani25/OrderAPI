package com.tgt.upcurve.OrderAPI.entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "customer_orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name="order_id")
    private Integer orderId;

    @Column(name="store_id")
    private Integer storeId;

    @Column(name="order_status")
    private String orderStatus;

    @Column(name="order_amount")
    private Float orderAmount;

    @Column(name="payment_status")
    private String paymentStatus;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "order_id", nullable = false)
    private List<OrderItems> orderItems = new ArrayList<>();
}
