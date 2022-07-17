package com.project.coffee.controller.bookings.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.coffee.model.Booking;
import com.project.coffee.repository.BookingRepository;

@RestController
@RequestMapping("/bookings")
public class BookingSearchController {
    
    @Autowired
    private BookingRepository bookingRepository;
    
    @GetMapping("")
    public List<Booking> search() {
        return bookingRepository.findAllByUserId(1L);
    }
}
