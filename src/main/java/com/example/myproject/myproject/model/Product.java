package com.example.myproject.myproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    @Id
    private int Id;
    private String name;
    private String description;
    private int price;


}
