package com.project.coffee.entities;

import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
public class User {
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String lastname;

    @Getter @Setter
    private String address;

    @Getter @Setter
    private String email;
}
