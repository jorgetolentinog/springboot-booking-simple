package com.project.coffee.repository.jpa.booking;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.coffee.model.Booking;

public interface BookingRepositoryJpaHelper extends JpaRepository<Booking, Long> {

	List<Booking> findAllByUserId(Long userId);
	
}
