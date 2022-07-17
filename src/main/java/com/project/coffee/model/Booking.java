package com.project.coffee.model;

import java.util.Date;

import lombok.Data;

@Data
public class Booking {
    private Long id;
    private Long tableId;
    private Long userId;
    private Long stateId;
    private Date date;
    private Integer guests;
}
