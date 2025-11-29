package com.example.myproject.myproject.model;

import lombok.Data;

@Data
public class UpdateRequest {
    private String firstName;
    private String lastName;
    private int Id;
    private String password;
    private String userId;
    private String email;
    private String businessType;
    private String state;
    private String district;
    private String mandal;
    private String village;
    private String mobile;
}
