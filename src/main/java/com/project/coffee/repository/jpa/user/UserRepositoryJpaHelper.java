package com.project.coffee.repository.jpa.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.coffee.model.User;

public interface UserRepositoryJpaHelper extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
