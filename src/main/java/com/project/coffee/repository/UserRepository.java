package com.project.coffee.repository;
import com.project.coffee.model.User;

public interface UserRepository {
    public User findUserById(Long id);
    public User save(User user);
}
