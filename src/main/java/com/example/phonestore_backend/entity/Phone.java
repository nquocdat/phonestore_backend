package com.example.phonestore_backend.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "phone")


public class Phone {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_id")
    private int phoneId;

    @Column(name = "name_phone", length = 512)
    private String name;

    @Column(name = "description",columnDefinition = "text")
    private String description;

    @Column(name = "listed_price")
    private double listedPrice;

    @Column(name = "selling_price")
    private double sellingPrice;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "model")
    private String model;

    @Column(name = "storage")
    private int storage;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "color")
    private String color;

    @Column(name = "average_rating")
    private double averageRating;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH,
    })
    @JoinTable(
            name = "phone_category",
            joinColumns = @JoinColumn(name = "phone_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> listCategory;

    @OneToMany(mappedBy = "phone", fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH, CascadeType.REMOVE
    })
    private List<Image> listImage;

    @OneToMany(mappedBy = "phone", fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH, CascadeType.ALL
    })
    private List<Review> listReview;

    @OneToMany(mappedBy = "phone", fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH,
    })
    private List<OrderItem> listOrderItem;

    @OneToMany(mappedBy = "phone", fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH, CascadeType.ALL
    })
    private List<CartItem> listCartItem;

    @OneToMany(mappedBy = "phone", fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH, CascadeType.ALL
    })
    private List<WishList> listWishList;
}
