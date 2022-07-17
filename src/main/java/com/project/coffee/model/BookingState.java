package com.project.coffee.model;

import lombok.Data;

@Data
public class BookingState {
    public static final Long PENDING = 1L;
    public static final Long CONFIRMED = 2L;
    public static final Long CANCELLED = 3L;

    private String id;
    private String name;
}
