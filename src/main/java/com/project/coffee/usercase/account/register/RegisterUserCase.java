package com.project.coffee.usercase.account.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.coffee.model.User;
import com.project.coffee.repository.UserRepository;

@Service
public class RegisterUserCase {
    
    @Autowired
    private UserRepository userRepository;

    public void register(RegisterRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setLastname(request.getLastname());
        user.setAddress(request.getAddress());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        userRepository.save(user);
    }
}
