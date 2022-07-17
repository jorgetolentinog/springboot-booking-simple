package com.project.coffee.usercase.booking.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.coffee.model.Booking;
import com.project.coffee.model.BookingState;
import com.project.coffee.repository.BookingRepository;

@Service
public class BookingCreateUseCase {
    @Autowired
    private BookingRepository bookingService;

    @PostMapping("")
    public Booking create(Booking booking) {
        booking.setUserId(9L);
        booking.setStateId(BookingState.PENDING);

        return bookingService.save(booking);
    }
}
