package com.project.coffee.usercase.booking.create;

import java.util.Date;

import lombok.Data;

@Data
public class BookingCreateRequest {
    private Long tableId;
    private Date date;
    private Integer guests;
}
