package com.project.coffee.services.booking;

import java.util.List;

import com.project.coffee.entities.Booking;

public interface BookingService {
    public Booking save(Booking booking);
    public List<Booking> findAllByUserId(Long userId);
    public Booking findById(Long id);
}
