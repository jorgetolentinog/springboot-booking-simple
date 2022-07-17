package com.project.coffee.usercase.booking.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.coffee.model.Booking;
import com.project.coffee.repository.BookingRepository;

@Service
public class BookingSearchUseCase {
     
    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping("")
    public List<Booking> search(Long userId) {
        return bookingRepository.findAllByUserId(userId);
    }
}
