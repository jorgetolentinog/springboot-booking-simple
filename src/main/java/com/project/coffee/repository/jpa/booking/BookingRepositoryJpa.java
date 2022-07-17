package com.project.coffee.repository.jpa.booking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.project.coffee.model.Booking;
import com.project.coffee.repository.BookingRepository;

@Service
@Primary
public class BookingRepositoryJpa implements BookingRepository {

	@Autowired
	private BookingRepositoryJpaHelper bookingRepositoryJpaHelper;               
	
	
	@Override
	public Booking save(Booking booking) {
		return bookingRepositoryJpaHelper.save(booking);
	}

	@Override
	public List<Booking> findAllByUserId(Long userId) {
		return (List<Booking>)bookingRepositoryJpaHelper.findAllByUserId(userId);
	}

	@Override
	public Booking findById(Long id) {
		return bookingRepositoryJpaHelper.findById(id).orElse(null);
	}

}
