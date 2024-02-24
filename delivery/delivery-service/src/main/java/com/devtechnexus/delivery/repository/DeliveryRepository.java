package com.devtechnexus.delivery.repository;

import com.devtechnexus.delivery.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devtechnexus.delivery.model.Delivery;

import java.util.List;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {


    @Query("SELECT d FROM Delivery d")
    public List<Delivery> getAll();

    public List<Delivery> findByUserId(String userId);

    @Query("Select i from Item i where i.delivery.id = ?1")
    public List<Item> findDeliveriesById(int id);
}
