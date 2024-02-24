package com.Product.Catalog.repository;

import com.Product.Catalog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogRepositroy extends JpaRepository<Product,Integer> {

    @Query("Select c from Product c where c.productName=?1")
    List<Product> findByProductName(String ProductName);

    @Query("Select c from Product c where c.id=?1")
    List<Product> findProductId(int ProductId);

    @Query("Select c from Product c where c.brand=?1")
    List<Product> findProductfromBrand(String Brand);

    @Query("Select c from Product c where c.category=?1")
    List<Product> findProductfromCategory(String Category);

}
