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
public class TractorOwner {
    @Id
 private int ownerId;
 private String ownerName;
 private String tractorStatus;
 private String currentLocation;

}
