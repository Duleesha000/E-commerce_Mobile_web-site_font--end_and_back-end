package com.devtechnexus.delivery.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "itemid")
    private int itemid;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "oid") // This specifies the foreign key column in the Item table
    private Delivery delivery;
}
