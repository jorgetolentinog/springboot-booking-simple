package com.project.coffee.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.coffee.model.Booking;
import com.project.coffee.service.token.TokenService;
import com.project.coffee.usercase.admin.booking.cancel.BookingCancelAdminUseCase;
import com.project.coffee.usercase.admin.booking.confirm.BookingConfirmAdminUseCase;
import com.project.coffee.usercase.admin.booking.search.BookingSearchAdminUseCase;

@RestController
@RequestMapping("/admin/bookings")
public class BookingAdminController {
    
    @Autowired
    private TokenService tokenService;

    @Autowired
    private BookingSearchAdminUseCase bookingSearchAdminUseCase;

    @Autowired
    private BookingConfirmAdminUseCase bookingConfirmAdminUseCase;

    @Autowired
    private BookingCancelAdminUseCase bookingCancelAdminUseCase;

    @GetMapping("")
    public List<Booking> search(@RequestHeader("authorization") String token) {
        Long userId = tokenService.decode(token).getUserId();
        return bookingSearchAdminUseCase.search(userId);
    }

    @PostMapping("/{bookingId}/confirm")
    public void confirm(@RequestHeader("authorization") String token, @PathVariable Long bookingId) {
        Long userId = tokenService.decode(token).getUserId();
        bookingConfirmAdminUseCase.confirm(userId, bookingId);
    }

    @PostMapping("/{bookingId}/cancel")
    public void cancel(@RequestHeader("authorization") String token, @PathVariable Long bookingId) {
        Long userId = tokenService.decode(token).getUserId();
        bookingCancelAdminUseCase.cancel(userId, bookingId);
    }
}
