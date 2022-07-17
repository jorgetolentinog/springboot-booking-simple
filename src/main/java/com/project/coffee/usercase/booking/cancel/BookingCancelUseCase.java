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

    public void cancel(Long userId, Long bookingId) {
        Booking booking = bookingService.findById(bookingId);
        if (booking == null) {
            throw new Error("Booking not found");
        }

        if (!booking.getUserId().equals(userId)) {
            throw new Error("You are not allowed to cancel this booking");
        }

        booking.setStateId(BookingState.CANCELLED);
        bookingService.save(booking);
    }
}
