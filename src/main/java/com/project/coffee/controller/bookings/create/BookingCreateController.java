package com.project.coffee.controller.bookings.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.coffee.model.Booking;
import com.project.coffee.model.BookingState;
import com.project.coffee.repository.BookingRepository;

@RestController
@RequestMapping("/bookings")
public class BookingCreateController {
    
    @Autowired
    private BookingRepository bookingService;

    @PostMapping("")
    public Booking create(@RequestBody Booking booking) {
        booking.setUserId(9L);
        booking.setStateId(BookingState.PENDING);

        return bookingService.save(booking);
    }

}
