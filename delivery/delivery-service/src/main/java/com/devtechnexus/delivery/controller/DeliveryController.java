package com.devtechnexus.delivery.controller;

import com.devtechnexus.delivery.dto.ParcelDTO;
import com.devtechnexus.delivery.model.Delivery;
import com.devtechnexus.delivery.model.Item;
import com.devtechnexus.delivery.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/deliveries")
@CrossOrigin
public class DeliveryController {

    @Autowired
    private DeliveryService service;

    @GetMapping("/")
    public List<Delivery> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public List<Delivery> getDeliveryByUserID(@PathVariable String id) {
        return service.getDeliveryByID(id);
    }

    /**
     * get items from a delivery
     * @param id id of the delivery
     * @return list of items under the delivery
     */
    @GetMapping("/items/{id}")
    public List<Item> getItemsInDelivery(@PathVariable int id) {
        return service.getDeliveryByItemID(id);
    }

    @PostMapping("/")
    public Delivery createDelivery(@RequestBody ParcelDTO parcel) {
        return service.createDelivery(parcel);
    }

    @PutMapping("/{id}")
    public Delivery paidDelivery(@PathVariable int id) {
        try {
            return service.updateDelivery(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * @param destination
     * @return distance in km to the destination from the store
     */
    @GetMapping("/route")
    public double getDistance(@RequestParam(name = "destination") String destination) {
        return service.getDistanceFromAPI(destination);
    }
}