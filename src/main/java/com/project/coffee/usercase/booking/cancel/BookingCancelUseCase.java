package com.project.coffee.usercase.booking.cancel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.coffee.model.Booking;
import com.project.coffee.model.BookingState;
import com.project.coffee.repository.BookingRepository;

@Service
public class BookingCancelUseCase {
     
    @Autowired
    private BookingRepository bookingService;

    public void cancel(Long id) {
        Booking booking = bookingService.findById(id);
        if (booking == null) {
            throw new Error("Booking not found");
        }

        booking.setStateId(BookingState.CANCELLED);
        bookingService.save(booking);
    }
}
