package com.example.myproject.myproject.repo;

import com.example.myproject.myproject.model.AutoDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepo extends JpaRepository<AutoDriver,Integer> {
}
