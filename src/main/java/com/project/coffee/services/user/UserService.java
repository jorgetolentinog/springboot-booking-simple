package com.project.coffee.services.user;
import com.project.coffee.entities.User;

public interface UserService {
    public User findUserById(Long id);
    public User save(User user);
}
