package com.project.coffee.repository.mock;

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

    @Override
    public Booking save(Booking booking) {
        if (booking.getId() == null) {
            booking.setId(2000L);
        }
    
        return booking;
    }

    @Override
    public List<Booking> findAllByUserId(Long userId) {
        Booking booking = new Booking();
        booking.setId(1L);
        booking.setTableId(1L);
        booking.setUserId(1L);
        booking.setDate(new Date());
        booking.setGuests(2);
        booking.setStateId(BookingState.PENDING);

        Booking booking2 = new Booking();
        booking2.setId(1L);
        booking2.setTableId(1L);
        booking2.setUserId(1L);
        booking2.setDate(new Date());
        booking2.setGuests(2);
        booking2.setStateId(BookingState.CONFIRMED);

        return List.of(booking, booking2);
    }

    @Override
    public Booking findById(Long id) {
        Booking booking = new Booking();
        booking.setId(1L);
        booking.setTableId(1L);
        booking.setUserId(1L);
        booking.setDate(new Date());
        booking.setGuests(2);
        booking.setStateId(BookingState.PENDING);
        return booking;
    }
}
