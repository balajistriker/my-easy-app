package com.example.myproject.myproject.controller;

import com.example.myproject.myproject.model.AutoDriver;
import com.example.myproject.myproject.model.Product;
import com.example.myproject.myproject.service.DriverService;
import com.example.myproject.myproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class AutoDriverController {
    @Autowired
    private DriverService service;
    @GetMapping("drivers")
    public List<AutoDriver> allDrivers(){
        return service.getALLDrivers();
    }
    @GetMapping("driver/{id}")
    public Optional<AutoDriver> driverById(@PathVariable("id") int id){
        return service.getDriverById(id);
    }
    @PostMapping("driver")
    public AutoDriver postProduct(@RequestBody AutoDriver driver){
        AutoDriver driver1= service.addDriver(driver);
        return  driver1;
    }


}
