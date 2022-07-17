package com.project.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.coffee.model.Booking;
import com.project.coffee.service.token.TokenService;
import com.project.coffee.usercase.booking.cancel.BookingCancelUseCase;
import com.project.coffee.usercase.booking.create.BookingCreateRequest;
import com.project.coffee.usercase.booking.create.BookingCreateUseCase;
import com.project.coffee.usercase.booking.search.BookingSearchUseCase;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingSearchUseCase bookingSearchUseCase;

    @Autowired
    private BookingCreateUseCase bookingCreateUseCase;

    @Autowired
    private BookingCancelUseCase bookingCancelUseCase;

    @Autowired
    private TokenService tokenService;

    @GetMapping("")
    public List<Booking> search(@RequestHeader("authorization") String token) {
        Long userId = tokenService.decode(token).getUserId();
        return bookingSearchUseCase.search(userId);
    }

    @PostMapping("")
    public Booking create(@RequestHeader("authorization") String token, @RequestBody BookingCreateRequest booking) {
        Long userId = tokenService.decode(token).getUserId();
        return bookingCreateUseCase.create(userId, booking);
    }

    @PostMapping("/{bookingId}/cancel")
    public void cancel(@RequestHeader("authorization") String token, @PathVariable Long bookingId) {
        Long userId = tokenService.decode(token).getUserId();
        bookingCancelUseCase.cancel(userId, bookingId);
    }
}
