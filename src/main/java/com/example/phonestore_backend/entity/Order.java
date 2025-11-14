package com.example.phonestore_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;
@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "delivery_address", length = 512)
    private String deliveryAddress;

    @Column(name = "purcahse_address", length = 512)
    private String purchaseAddress;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "delivery_cost")
    private double deliveryCost;

    @Column(name = "payment_cost")
    private double paymentCost;

    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH,
    })
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH, CascadeType.REMOVE, CascadeType.ALL
    })
    private List<OrderItem> listOrderItem;

    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH,
    })
    @JoinColumn(name = "payment_id", nullable = true)
    private PaymentStatus paymentStatus;

    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH,
    })
    @JoinColumn(name = "delivery_id", nullable = true)
    private DeliveryStatus deliveryStatus;
}
