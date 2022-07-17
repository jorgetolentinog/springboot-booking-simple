package com.project.coffee.entities;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class Booking {
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private Long tableId;

    @Getter @Setter
    private Long userId;

    @Getter @Setter
    private Long stateId;

    @Getter @Setter
    private Date date;

    @Getter @Setter
    private Integer guests;
}
