package com.project.coffee.usercase.admin.booking.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.coffee.model.Booking;
import com.project.coffee.model.User;
import com.project.coffee.repository.BookingRepository;
import com.project.coffee.repository.UserRepository;

@Service
public class BookingSearchAdminUseCase {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> search(Long userId) {
        User user = userRepository.findById(userId);
        if (user == null) {
            throw new Error("User not found");
        }

        if (!user.getIsAdmin()) {
            throw new Error("You are not allowed to search all booking");
        }

        return bookingRepository.findAll();
    }
}
