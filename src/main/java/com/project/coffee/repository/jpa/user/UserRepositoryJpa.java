package com.project.coffee.repository.jpa.user;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.coffee.model.User;
import com.project.coffee.repository.UserRepository;

public class UserRepositoryJpa implements UserRepository {

	@Autowired
	private UserRepositoryJpaHelper userRepositoryJpaHelper;

	@Override
	public User findById(Long id) {
		return userRepositoryJpaHelper.findById(id).orElse(null);
	}

	@Override
	public User save(User user) {
		return userRepositoryJpaHelper.save(user);
	}

	@Override
	public User findByEmail(String email) {
		return userRepositoryJpaHelper.findByEmail(email);
	}

}
