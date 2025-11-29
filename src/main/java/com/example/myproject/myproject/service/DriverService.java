package com.example.myproject.myproject.service;

import com.example.myproject.myproject.model.AutoDriver;
import com.example.myproject.myproject.repo.DriverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DriverService {
    @Autowired
    DriverRepo repo;
    public List<AutoDriver> getALLDrivers() {
        return repo.findAll();
    }

    public Optional<AutoDriver> getDriverById(int id) {
        return repo.findById(id);
    }

    public AutoDriver addDriver(AutoDriver driver) {
        return repo.save(driver);
    }


}
