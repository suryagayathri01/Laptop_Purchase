package com.ust.Laptop_variety.repo;

import com.ust.Laptop_variety.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LaptopRepository extends JpaRepository<Laptop, Long> {
    List<Laptop> findByPriceBetween(Double minPrice, Double maxPrice);
}