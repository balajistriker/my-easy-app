package com.example.myproject.myproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Component
public class AutoDriver {
    @Id
    private int driverId;
    private  String driverName;
    private String driverStatus;
    private  String currentLocation;
    private String vehicleNumber;


}
