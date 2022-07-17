package com.project.coffee.controllers;

import java.util.List;
import java.util.logging.Logger;

// import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.coffee.entities.Booking;
import com.project.coffee.entities.BookingState;
import com.project.coffee.services.booking.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {

    Logger logger = Logger.getLogger(BookingController.class.getName());


    @Autowired
    private BookingService bookingService;
    
    @GetMapping("")
    public List<Booking> index() {
        return bookingService.findAllByUserId(1L);
    }

    @PostMapping("")
    public Booking create(@RequestBody Booking booking) {
        booking.setUserId(9L);
        booking.setStateId(BookingState.PENDING);

        return bookingService.save(booking);
    }

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
