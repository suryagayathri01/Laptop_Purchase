package com.ust.Laptop_variety.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.Laptop_variety.model.Laptop;
import com.ust.Laptop_variety.repo.LaptopRepository;

@Service
public class LaptopService {

    
    @Autowired
    private LaptopRepository laptopRepository;

    public Laptop addLaptop(Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    public List<Laptop> getAllLaptops() {
        return laptopRepository.findAll();
    }

    public List<Laptop> filterLaptopsByBudget(Double minPrice, Double maxPrice) {
        return laptopRepository.findByPriceBetween(minPrice, maxPrice);
    }
}