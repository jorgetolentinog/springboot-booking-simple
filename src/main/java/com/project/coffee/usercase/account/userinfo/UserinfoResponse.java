package com.project.coffee.usercase.account.userinfo;

import lombok.Data;

@Data
public class UserinfoResponse {
    private Long id;
    private String name;
    private String lastname;
    private String address;
    private String email;
}
