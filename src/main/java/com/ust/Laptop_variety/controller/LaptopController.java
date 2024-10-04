package com.ust.Laptop_variety.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ust.Laptop_variety.model.Laptop;
import com.ust.Laptop_variety.service.LaptopService;

@RestController
@RequestMapping("/ust")
public class LaptopController {

    @Autowired
    private LaptopService laptopService;


    @PostMapping
    public ResponseEntity<Laptop> createLaptop(@RequestBody Laptop laptop) {
        Laptop createdLaptop = laptopService.addLaptop(laptop);
        return new ResponseEntity<>(createdLaptop, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Laptop>> getAllLaptops() {
        List<Laptop> laptops = laptopService.getAllLaptops();
        return new ResponseEntity<>(laptops, HttpStatus.OK);
    }


    @GetMapping("/filter")
    public ResponseEntity<List<Laptop>> filterLaptopsByBudget(
            @RequestParam Double minPrice,
            @RequestParam Double maxPrice) {
        List<Laptop> filteredLaptops = laptopService.filterLaptopsByBudget(minPrice, maxPrice);
        return new ResponseEntity<>(filteredLaptops, HttpStatus.OK);
    }
}