package com.devtechnexus.delivery.dto;

import com.devtechnexus.delivery.model.Item;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class ParcelDTO {

    private List<Item> contents;
    private String userId;
    private String address;
    private Timestamp datetime;
    private String status;
}
