package com.project.coffee.usercase.admin.booking.cancel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.coffee.model.Booking;
import com.project.coffee.model.BookingState;
import com.project.coffee.model.User;
import com.project.coffee.repository.BookingRepository;
import com.project.coffee.repository.UserRepository;

@Service
public class BookingCancelAdminUseCase {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookingRepository bookingService;

    public void cancel(Long userId, Long id) {
        User user = userRepository.findById(id);
        if (user == null) {
            throw new Error("User not found");
        }

        if (!user.getIsAdmin()) {
            throw new Error("You are not allowed to cancel this booking");
        }

        Booking booking = bookingService.findById(id);
        if (booking == null) {
            throw new Error("Booking not found");
        }

        booking.setStateId(BookingState.CANCELLED);
        bookingService.save(booking);
    }
}
