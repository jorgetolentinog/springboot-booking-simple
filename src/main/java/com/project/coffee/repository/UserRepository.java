package com.project.coffee.repository;
import com.project.coffee.model.User;

public interface UserRepository {
    public User findById(Long id);
    public User save(User user);
    public User findByEmail(String email);
}
