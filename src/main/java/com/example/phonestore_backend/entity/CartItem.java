package com.example.phonestore_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cart_item")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartitem_id")
    private long cartItemId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "selling_price")
    private double sellingprice;

    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH,
    })
    @JoinColumn(name = "phone_id", nullable = false)
    private Phone phone;

    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH,
    })
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

}
