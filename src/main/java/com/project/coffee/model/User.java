package com.project.coffee.model;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private String lastname;
    private String address;
    private String email;
}
