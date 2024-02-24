package com.Product.Catalog.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "catalog")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "productname")
    private String productName;

    @Column(name = "Productdescription")
    private String description;

    @Column(name = "category")
    private String category;

    @Column(name = "brand")
    private String brand;

    @Column(name = "price")
    private double price;

    @Column(name = "currency")
    private String currency;

    @Column(name = "weight")
    private float weight;

    @Column(name = "dimension")
    private String dimensions;

    @Column(name = "stockquantity")
    private int stock_Quantity;

    @Column(name = "imgurl")
    private String ImgUrl;

}
