package com.project.coffee.repository;

import java.util.List;

import com.project.coffee.model.Booking;

public interface BookingRepository {
    public Booking save(Booking booking);
    public List<Booking> findAllByUserId(Long userId);
    public Booking findById(Long id);
}
