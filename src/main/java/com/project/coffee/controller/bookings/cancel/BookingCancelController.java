package com.project.coffee.controller.bookings.cancel;

import java.util.logging.Logger;

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
public class BookingCancelController {
    Logger logger = Logger.getLogger(BookingCancelController.class.getName());
    
    @Autowired
    private BookingRepository bookingService;

    @PostMapping("/{id}/cancel")
    public void cancel(@PathVariable Long id) {
        logger.info("An INFO Message");

        Booking booking = bookingService.findById(id);
        if (booking == null) {
            throw new Error("Booking not found");
        }

        booking.setStateId(BookingState.CANCELLED);
        bookingService.save(booking);
    }
}
