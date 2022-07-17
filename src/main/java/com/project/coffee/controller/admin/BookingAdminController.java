package com.project.coffee.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.coffee.usercase.admin.booking.confirm.BookingConfirmUseCase;

@RestController
@RequestMapping("/admin/bookings")
public class BookingAdminController {
    
    @Autowired
    private BookingConfirmUseCase bookingConfirmUseCase;

    @PostMapping("/{id}/confirm")
    public void confirm(@PathVariable Long id) {
        bookingConfirmUseCase.confirm(id);
    }
}
