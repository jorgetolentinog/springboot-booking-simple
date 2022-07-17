package com.project.coffee.usercase.account.register;

import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String lastname;
    private String address;
    private String email;
    private String password;
}
