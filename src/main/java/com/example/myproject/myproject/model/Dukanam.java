package com.example.myproject.myproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Entity
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Dukanam {
    @Id
    private int Id;
    private String userId;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String businessType;
    private String state;
    private String district;
    private String mandal;
    private String village;
    private String mobile;
    @Enumerated(EnumType.STRING)  // stores role as text like "ADMIN"
    private UserRole role;

//    private int id;
//    private String ownerName;
//    private String currentStatus;
//    private List<String> availableVegetables;
//    private List<String> availableDrinks;
//    private List<String> available_non_vegFood_Items;

}
