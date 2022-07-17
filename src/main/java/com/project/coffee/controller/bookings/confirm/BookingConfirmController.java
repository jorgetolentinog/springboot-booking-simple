package com.project.coffee.controller.bookings.confirm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.coffee.model.Booking;
import com.project.coffee.model.BookingState;
import com.project.coffee.repository.BookingRepository;

@RestController
@RequestMapping("/bookings")
public class BookingConfirmController {
    
    @Autowired
    private BookingRepository bookingService;

    @PostMapping("/{id}/confirm")
    public void confirm(@PathVariable Long id) {
        Booking booking = bookingService.findById(id);
        if (booking == null) {
            throw new Error("Booking not found");
        }

        booking.setStateId(BookingState.CONFIRMED);
        bookingService.save(booking);
    }
}
