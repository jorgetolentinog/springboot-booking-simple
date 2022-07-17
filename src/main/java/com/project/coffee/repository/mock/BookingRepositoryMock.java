package com.project.coffee.repository.mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.project.coffee.model.Booking;
import com.project.coffee.model.BookingState;
import com.project.coffee.repository.BookingRepository;

@Service
@Primary
public class BookingRepositoryMock implements BookingRepository {
    private List<Booking> bookings = new ArrayList<>();

    public BookingRepositoryMock() {
        Booking booking = new Booking();
        booking.setId(1L);
        booking.setTableId(1L);
        booking.setUserId(1L);
        booking.setDate(new Date());
        booking.setGuests(2);
        booking.setStateId(BookingState.PENDING);
        bookings.add(booking);

        Booking booking2 = new Booking();
        booking2.setId(2L);
        booking2.setTableId(2L);
        booking2.setUserId(1L);
        booking2.setDate(new Date());
        booking2.setGuests(3);
        booking2.setStateId(BookingState.CONFIRMED);
        bookings.add(booking2);
    }

    @Override
    public Booking save(Booking booking) {
        if (booking.getId() == null) {
            booking.setId(new Date().getTime());
            bookings.add(booking);
        }

        return booking;
    }

    @Override
    public List<Booking> findAllByUserId(Long userId) {
        return bookings;
    }

    @Override
    public Booking findById(Long id) {
        return bookings.stream()
                .filter(booking -> booking.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Booking> findAll() {
        return bookings;
    }
}
