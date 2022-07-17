package com.project.coffee.usercase.admin.booking.confirm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.coffee.model.Booking;
import com.project.coffee.model.BookingState;
import com.project.coffee.model.User;
import com.project.coffee.repository.BookingRepository;
import com.project.coffee.repository.UserRepository;

@Service
public class BookingConfirmAdminUseCase {
     
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookingRepository bookingService;

    public void confirm(Long userId, Long bookingId) {
        User user = userRepository.findById(userId);
        if (user == null) {
            throw new Error("User not found");
        }

        if (!user.getIsAdmin()) {
            throw new Error("You are not allowed to confirm this booking");
        }

        Booking booking = bookingService.findById(bookingId);
        if (booking == null) {
            throw new Error("Booking not found");
        }

        booking.setStateId(BookingState.CONFIRMED);
        bookingService.save(booking);
    }
}
