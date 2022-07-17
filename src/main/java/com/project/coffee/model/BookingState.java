package com.project.coffee.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class BookingState {
    public static final Long PENDING = 1L;
    public static final Long CONFIRMED = 2L;
    public static final Long CANCELLED = 3L;

	@Id
    private String id;
	
    private String name;
}
