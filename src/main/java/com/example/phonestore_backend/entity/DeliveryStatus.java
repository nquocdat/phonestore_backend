package com.example.phonestore_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
@Table(name = "delivery_status")
public class DeliveryStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private int deliveryId;

    @Column(name = "name_delivery")
    private String nameDelivery;

    @Column(name = "description")
    private String description;

    @Column(name = "delivery_cost")
    private double deliveryCost;

    @OneToMany(mappedBy = "deliveryStatus", fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH, CascadeType.REMOVE
    })
    private List<Order> listOrder;
}
