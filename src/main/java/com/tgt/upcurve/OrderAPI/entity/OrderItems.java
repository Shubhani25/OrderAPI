package com.tgt.upcurve.OrderAPI.entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "order_items")
public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "order_id", insertable = false, updatable = false)
    private Integer orderId;

    @Column(name = "item_id")
    private Integer itemId;

    @Column(name="item_price")
    private Float itemPrice;

    @Column(name="item_description")
    private String itemDescription;

}
