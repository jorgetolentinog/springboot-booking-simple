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
    public Booking create(Long userId, BookingCreateRequest request) {
        Booking booking = new Booking();
        booking.setUserId(userId);
        booking.setStateId(BookingState.PENDING);
        booking.setTableId(request.getTableId());
        booking.setDate(request.getDate());
        booking.setGuests(request.getGuests());

        return bookingService.save(booking);
    }
}
