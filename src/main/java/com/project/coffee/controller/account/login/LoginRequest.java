package com.project.coffee.controller.account.login;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
