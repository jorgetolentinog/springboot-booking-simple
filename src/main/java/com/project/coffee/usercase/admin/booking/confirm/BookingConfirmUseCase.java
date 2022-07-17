package com.project.coffee.usercase.admin.booking.confirm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.coffee.model.Booking;
import com.project.coffee.model.BookingState;
import com.project.coffee.repository.BookingRepository;

@Service
public class BookingConfirmUseCase {
     
    @Autowired
    private BookingRepository bookingService;

    public void confirm(Long id) {
        Booking booking = bookingService.findById(id);
        if (booking == null) {
            throw new Error("Booking not found");
        }

        booking.setStateId(BookingState.CONFIRMED);
        bookingService.save(booking);
    }
}
