package com.devtechnexus.delivery.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;


import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name="delivery")

public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "address")
    private String address;

    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp datetime;

    @Column(name = "status")
    private String status;

    @JsonIgnore
    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<Item> items;

}
