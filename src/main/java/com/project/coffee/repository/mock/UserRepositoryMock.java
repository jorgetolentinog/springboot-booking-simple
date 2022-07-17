package com.project.coffee.repository.mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.project.coffee.model.User;
import com.project.coffee.repository.UserRepository;

@Service
@Primary
public class UserRepositoryMock implements UserRepository {
    private List<User> users = new ArrayList<>();

    public UserRepositoryMock() {
        User user = new User();
        user.setId(1000L);
        user.setName("John");
        user.setLastname("Doe");
        user.setAddress("123 Main St");
        user.setEmail("john@doe.com");
        user.setPassword("1234");
        users.add(user);

        User user2 = new User();
        user2.setId(2000L);
        user2.setName("Jorge");
        user2.setLastname("Armando");
        user2.setAddress("123 Main St");
        user2.setEmail("jorge@armando.com");
        user2.setPassword("5678");
        users.add(user2);
    }

    public User findUserById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User save(User user) {
        user.setId(new Date().getTime());
        users.add(user);
        return user;
    }

    @Override
    public User findByEmail(String email) {
        return users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }
}
