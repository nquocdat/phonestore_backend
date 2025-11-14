package com.example.phonestore_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
@Table(name = "payment_status")
public class PaymentStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private int paymentId;

    @Column(name = "name_payment")
    private String namePayment;

    @Column(name = "desciption")
    private String description;

    @Column(name = "payment_cost")
    private double paymentCost;

    @OneToMany(mappedBy = "paymentStatus", fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH, CascadeType.REMOVE
    })
    private List<Order> listOrder;
}
