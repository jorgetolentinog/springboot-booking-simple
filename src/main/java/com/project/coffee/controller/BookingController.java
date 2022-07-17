package com.project.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.coffee.model.Booking;
import com.project.coffee.usercase.booking.cancel.BookingCancelUseCase;
import com.project.coffee.usercase.booking.create.BookingCreateUseCase;
import com.project.coffee.usercase.booking.search.BookingSearchUseCase;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    
    @Autowired
    private BookingSearchUseCase bookingSearchUseCase;
    
    @Autowired
    private BookingCreateUseCase bookingCreateUseCase;

    @Autowired
    private BookingCancelUseCase bookingCancelUseCase;

    @GetMapping("")
    public List<Booking> search() {
        return bookingSearchUseCase.search();
    }
    
    @PostMapping("")
    public Booking create(@RequestBody Booking booking) {
        return bookingCreateUseCase.create(booking);
    }

    @PostMapping("/{id}/cancel")
    public void cancel(@PathVariable Long id) {
        bookingCancelUseCase.cancel(id);
    }
}
