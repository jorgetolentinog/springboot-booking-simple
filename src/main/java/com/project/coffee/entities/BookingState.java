package com.project.coffee.entities;

import lombok.Getter;
import lombok.Setter;

public class BookingState {
    public static final Long PENDING = 1L;
    public static final Long CONFIRMED = 2L;
    public static final Long CANCELLED = 3L;

    @Getter @Setter
    private String id;

    @Getter @Setter
    private String name;
}
