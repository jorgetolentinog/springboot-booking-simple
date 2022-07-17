package com.project.coffee.repository.mock;

import org.springframework.stereotype.Service;

import com.project.coffee.model.User;
import com.project.coffee.repository.UserRepository;

@Service
public class UserRepositoryMock implements UserRepository {

    public User findUserById(Long id) {
        User user = new User();
        user.setId(id);
        user.setName("John");
        user.setLastname("Doe");
        user.setAddress("123 Main St");
        user.setEmail("john@doe.com");

        return user;
    }

    @Override
    public User save(User user) {
        user.setId(1000L);
        return user;
    }
}
