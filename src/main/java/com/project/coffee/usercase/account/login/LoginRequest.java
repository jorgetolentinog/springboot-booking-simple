package com.project.coffee.usercase.account.login;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
