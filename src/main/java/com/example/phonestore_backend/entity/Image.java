package com.example.phonestore_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private int imageId;

    @Column(name = "image_name", length = 256)
    private  String imageName;

    @Column(name = "icon")
    private boolean icon;

    @Column(name = "link")
    private String link;

    @Column(name = "data_image")
    @Lob
    private String data;

    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH,
    })
    @JoinColumn(name = "phone_id", nullable = false)
    private Phone phone;
}
